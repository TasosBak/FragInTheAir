package com.example.admin.fragintheair;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 20/12/2016.
 */

class CustomAdapter extends ArrayAdapter<Result>{
    ArrayList<Result> objectList;
    Result flightObject;
    public CustomAdapter(Context context, ArrayList<Result> objects) {
        super(context, R.layout.single_row_xml, objects);
        objectList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.single_row_xml, parent, false);

        flightObject = getItem(position);
        Log.i("LOG TAGGG", "custom adapter position " + position);
        
        Integer airlineText = position;
        String originAirportText = flightObject.getItineraries().get(0).getOutbounds().get(0).originAirport;
        String destinationAirportText = flightObject.getItineraries().get(0).getOutbounds().get(flightObject.getItineraries().get(0).getOutbounds().size()-1).destinationAirport;
        String departureDateText = flightObject.getItineraries().get(0).getOutbounds().get(0).departsAt;
        String arrivalDateText = flightObject.getItineraries().get(0).getOutbounds().get(flightObject.getItineraries().get(0).getOutbounds().size()-1).arrivesAt;
        String fareText = flightObject.adultTotalFare;

        
        

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
        if(flightObject.getItineraries().get(0).getOutbounds().size()>1)
            durationTotal.setText("Με στάση");
        else
            durationTotal.setText("Απευθείας");

        return customView;
    }

    @Override
    public int getCount() {

        return objectList.size();
    }

    @Override
    public int getPosition(Result item) {

        return objectList.indexOf(item);
    }

    @Nullable
    @Override
    public Result getItem(int position) {

        return objectList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }


}
