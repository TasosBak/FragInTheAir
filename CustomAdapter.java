package com.example.admin.fragintheair;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 20/12/2016.
 */

class CustomAdapter extends ArrayAdapter<Itinerary>{
    ArrayList<Itinerary> itineraryList;
    Itinerary itinerary;
    Integer flag=1;
    public CustomAdapter(Context context, ArrayList<Itinerary> itineraries) {
        super(context, R.layout.single_row_xml, itineraries);
        itineraryList = itineraries;

    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.single_row_xml, parent, false);

        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "position: " + getItem(position).getResultId(), Toast.LENGTH_SHORT).show();

            }
        });
        itinerary = getItem(position);
        Log.i("LOG TAGGG", "custom adapter position " + position);




        if(itinerary.getResultId()%2 == 0) {
            Log.i("LOG CAAAT", "mpainei sthn if"+flag);
            customView.setBackgroundColor(Color.parseColor("#b6bdd9"));
        }
        else if(itinerary.getResultId()%2 != 0){
            Log.i("LOG CAAAT", "mpainei sthn else  : " +flag);
            customView.setBackgroundColor(Color.parseColor("#cbd3f2"));
        }
        Integer airlineText = position;
        String originAirportText = itinerary.outbounds.get(0).originAirport;
        String destinationAirportText = itinerary.outbounds.get(itinerary.outbounds.size()-1).destinationAirport;
        String departureDateText = itinerary.outbounds.get(0).departsAt;
        String arrivalDateText = itinerary.outbounds.get(itinerary.outbounds.size()-1).arrivesAt;
        String fareText = itinerary.fare.adultTotalFare;
        if(itinerary.getResultId()%2==0)
            flag++;



        String departureTime, arrivalTime;
        //int depInt, arrInt;

        TextView airline = (TextView) customView.findViewById(R.id.airline_textview);
        TextView originAirport = (TextView) customView.findViewById(R.id.originAirport_textview);
        TextView destinationAirport = (TextView) customView.findViewById(R.id.destinationAirport_textview);
        TextView departureDate = (TextView) customView.findViewById(R.id.departureTime_textview);
        TextView arrivalDate = (TextView) customView.findViewById(R.id.arrivalTime_textview);
        TextView fare = (TextView) customView.findViewById(R.id.fare_textview);
        TextView durationTotal = (TextView ) customView.findViewById(R.id.stop);


        airline.setText(airlineText.toString());
        originAirport.setText(originAirportText);
        destinationAirport.setText(destinationAirportText);
        departureTime = departureDateText.substring(departureDateText.lastIndexOf("T") + 1);
        departureDate.setText(departureTime);
        arrivalTime = arrivalDateText.substring(arrivalDateText.lastIndexOf("T") + 1);
        arrivalDate.setText(arrivalTime);
        fare.setText(fareText);
        if(itinerary.getOutbounds().size()>1)
            durationTotal.setText("Με στάση");
        else
            durationTotal.setText("Απευθείας");


        return customView;
    }

    @Override
    public int getCount() {

        return itineraryList.size();
    }

    @Override
    public int getPosition(Itinerary item) {

        return itineraryList.indexOf(item);
    }

    @Nullable
    @Override
    public Itinerary getItem(int position) {

        return itineraryList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }


}
