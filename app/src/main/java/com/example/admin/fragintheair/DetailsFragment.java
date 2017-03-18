package com.example.admin.fragintheair;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Admin on 26/12/2016.
 */

public class DetailsFragment extends Fragment{
    String LOG_TAG = "DetailsFragmentLog";
    Itinerary itinerary;

    CollapsingToolbarLayout collapsingToolbar;
    AppBarLayout appBar;

    TextView dateTextView, airportsTextView, timeTextView, stopsTextView, fareTextView, adultsTextView, childrenTextView, infantsTextView;

    private RecyclerView recyclerView;
    private ArrayList<Flight> flightList;
    private CardAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "onCreate");
        Bundle args = getArguments();
        itinerary = args.getParcelable("itinerary selected");
        flightList = itinerary.getOutbounds();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, null);
        Log.i(LOG_TAG, "onCreateView");

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        appBar = (AppBarLayout) view.findViewById(R.id.appbar);

        dateTextView = (TextView) view.findViewById(R.id.date_text_view);
        airportsTextView = (TextView) view.findViewById(R.id.airports_text_view);
        timeTextView = (TextView) view.findViewById(R.id.departing_arrival_time_text_view);
        stopsTextView = (TextView) view.findViewById(R.id.stops_text_view);
        fareTextView = (TextView) view.findViewById(R.id.fare_text_view);
        adultsTextView = (TextView) view.findViewById(R.id.adults_edit_text);
        childrenTextView = (TextView) view.findViewById(R.id.kids_edit_text);
        infantsTextView = (TextView) view.findViewById(R.id.baby_edit_text);

        dateTextView.setText(itinerary.getOutbounds().get(0).departsAt.substring(0, 10));
        airportsTextView.setText(itinerary.getOutbounds().get(0).getOriginAirport() + " to " + itinerary.getOutbounds().get(itinerary.getOutbounds().size()-1).destinationAirport);
        timeTextView.setText(itinerary.getOutbounds().get(0).getDepartsAt().substring(itinerary.getOutbounds().get(0).getDepartsAt().lastIndexOf("T") + 1) + " - " + itinerary.getOutbounds().get(itinerary.getOutbounds().size()-1).arrivesAt.substring(itinerary.getOutbounds().get(itinerary.getOutbounds().size()-1).arrivesAt.lastIndexOf("T") + 1));
        if(itinerary.getOutbounds().size()>1)
            if(itinerary.getOutbounds().size() == 2)
                //an to dromologio exei duo podia shmainei oti exei 1 stash, gi'auto emfanizw size-1
                stopsTextView.setText(itinerary.getOutbounds().size()-1 + " στάση");
            else
                stopsTextView.setText(itinerary.getOutbounds().size()-1 + " στάσεις");
        else
            stopsTextView.setText("Απευθείας");
        fareTextView.setText(itinerary.getFare().getTotalPrice());

        adultsTextView.setText(itinerary.getAdults().toString());
        //Log.i(LOG_TAG, "adults:" + itinerary.getAdults().toString());
//        try {
//            childrenTextView.setText(itinerary.children.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            infantsTextView.setText(itinerary.infants.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        initCollapsingToolbar();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        adapter = new CardAdapter(getContext(), flightList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareCards();


        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) view.findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "onStart");
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_LONG).show();
    }

    /**
     * Adding few albums for testing
     */
    private void prepareCards() {
        Log.i(LOG_TAG, "prepareCards");
        flightList = itinerary.getOutbounds();
        adapter.notifyDataSetChanged();
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbarLayout = collapsingToolbar;
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = appBar;
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
