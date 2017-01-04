package com.example.admin.fragintheair;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Admin on 19/12/2016.
 */

public class MyListFragment extends ListFragment {
    String LOG_TAG = "TTTAG LOG";

    public ArrayList<Result> results = new ArrayList<Result>();


    public ArrayList<Itinerary> emptyList = new ArrayList<Itinerary>();

    itemClickedListener mCallback;
    Itinerary itinerary;

    public interface itemClickedListener {
        public void itemClicked(int position);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Toast.makeText(getContext(), "position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        //list = (ListView)view.findViewById(android.R.id.list);
        Log.i(LOG_TAG, "onCreateView");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        results = args.getParcelableArrayList("results");
        Log.i(LOG_TAG, "onStart");


        CustomAdapter adapter = new CustomAdapter(getActivity(), emptyList);
        setListAdapter(adapter);

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).itineraries.size(); j++) {
                adapter.add(results.get(i).itineraries.get(j));
            }
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(LOG_TAG, "onActivityCreated");


    }


/*
    public class CustomAdapter extends ArrayAdapter<FlightObject> {

        public CustomAdapter(Context context, ArrayList<FlightObject> objects) {
            super(context, 0, objects);
            Log.i(LOG_TAG, "constructor tou adapter");
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.i(LOG_TAG, "getView");
            // Get the data item for this position
            FlightObject object = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                Log.i(LOG_TAG, "mphke sthn if");
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_row_xml, parent, false);
            }

            // Populate the data into the template view using the data object
            text.setText(object.arrivesAt);
            text2.setText(object.totalPrice);
            // Return the completed view to render on screen
            return convertView;
        }
    }
    */
}





