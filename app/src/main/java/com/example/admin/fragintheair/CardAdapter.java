package com.example.admin.fragintheair;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 15/1/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    private Context myContext;
    private ArrayList<Flight> flightList;

    private String LOG_CAT = "CardAdapterLog";

    public CardAdapter(Context mContext, ArrayList<Flight> flightList) {
        this.myContext = mContext;
        this.flightList = flightList;
        Log.i(LOG_CAT, "CardAdapter");
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView airportsTextView, timeTextView, classTextView, bCodeTextView;

        public MyViewHolder(View view) {
            super(view);
            airportsTextView = (TextView) view.findViewById(R.id.card_aiports);
            timeTextView = (TextView) view.findViewById(R.id.card_date);
            classTextView = (TextView) view.findViewById(R.id.card_class);
            bCodeTextView = (TextView) view.findViewById(R.id.card_bcode);
            Log.i(LOG_CAT, "MyViewHolder");
        }
    }

    @Override
    public CardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flight_card, parent, false);

        Log.i(LOG_CAT, "CardAdapter.MyViewHolder");

        return new MyViewHolder(itemView);
    }













    @Override
    //public void onBindViewHolder(CardAdapter.MyViewHolder holder, int position) {
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Flight flight = flightList.get(position);
        holder.airportsTextView.setText(flight.getOriginAirport() + " - " + flight.getDestinationAirport());
        holder.timeTextView.setText(flight.departsAt + " - " + flight.arrivesAt);
        holder.classTextView.setText(flight.getTravelClass());
        holder.bCodeTextView.setText("Booking code: " + flight.getBookingCode());

        Log.i(LOG_CAT, "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }
}
