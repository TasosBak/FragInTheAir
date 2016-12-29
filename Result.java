package com.example.admin.fragintheair;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Result implements Parcelable {

    String currency;

    ArrayList<Itinerary> itineraries = null;

    //empty constructor
    public Result() {}




    //getters kai setters

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public ArrayList<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(ArrayList<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public void addToItineraries(Itinerary itinerary) {
        this.itineraries.add(itinerary);
    }






    //diafora gia to implementation tou parcelable
    protected Result(Parcel in) {
        currency = in.readString();
        if (in.readByte() == 0x01) {
            itineraries = new ArrayList<Itinerary>();
            in.readList(itineraries, Itinerary.class.getClassLoader());
        } else {
            itineraries = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(currency);
        if (itineraries == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(itineraries);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}

