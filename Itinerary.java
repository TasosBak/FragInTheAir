package com.example.admin.fragintheair;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Admin on 25/12/2016.
 */
public class Itinerary implements Parcelable {

    ArrayList<Flight> outbounds;
    ArrayList<Flight> inbounds;

    public Itinerary() {}


    public ArrayList<Flight> getOutbounds() {
        return outbounds;
    }

    public void setOutbounds(ArrayList<Flight> outbounds) {
        this.outbounds = outbounds;
    }

    public void addToOutbounds(Flight outbound) {
        this.outbounds.add(outbound);
    }





    public ArrayList<Flight> getInbounds() {
        return inbounds;
    }

    public void setInbounds(ArrayList<Flight> inbounds) {
        this.inbounds = inbounds;
    }

    public void addToInbounds(Flight inbound) {
        this.inbounds.add(inbound);
    }

    protected Itinerary(Parcel in) {
        if (in.readByte() == 0x01) {
            outbounds = new ArrayList<Flight>();
            in.readList(outbounds, Flight.class.getClassLoader());
        } else {
            outbounds = null;
        }
        if (in.readByte() == 0x01) {
            inbounds = new ArrayList<Flight>();
            in.readList(inbounds, Flight.class.getClassLoader());
        } else {
            inbounds = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (outbounds == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(outbounds);
        }
        if (inbounds == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(inbounds);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Itinerary> CREATOR = new Parcelable.Creator<Itinerary>() {
        @Override
        public Itinerary createFromParcel(Parcel in) {
            return new Itinerary(in);
        }

        @Override
        public Itinerary[] newArray(int size) {
            return new Itinerary[size];
        }
    };
}
