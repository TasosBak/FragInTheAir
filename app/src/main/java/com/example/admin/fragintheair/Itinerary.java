package com.example.admin.fragintheair;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Itinerary implements Parcelable {

    ArrayList<Flight> outbounds;
    ArrayList<Flight> inbounds;

    // *****SOS**** to fare kanonika einai property tou result!! to evala omws edw giati den
    //vrhka allo tropo na steilw ston CustomAdapter tis plhrofories tou fare gia ka8e itinerary
    //ginetai polu diplografh etsi. 8a prepei na yparxei allos tropos
    Fare fare;


    //mpakalikh lush gia na mporw na vriskw se pio result anhkei to ka8e itinerary
    //8a to xrhsimopoihsw sthn OnListItemClick tou MyListFragment
    Integer resultId;

    //vazw san properties tou itinerary kai tous passengers
    //den to vazw san property tou flight giati gia ka8e flight oi passengers einai oi idioi
    //kanonika einai property
    Integer adults;
    Integer children;
    Integer infants;


    public Itinerary() {}


    public ArrayList<Flight> getOutbounds() {
        return outbounds;
    }

    public void setOutbounds(ArrayList<Flight> outbounds) {
        this.outbounds = outbounds;
    }

    public void addToOutbounds(Flight flight) {
        this.outbounds.add(flight);
    }

    public ArrayList<Flight> getInbounds() {
        return inbounds;
    }

    public void setInbounds(ArrayList<Flight> inbounds) {
        this.inbounds = inbounds;
    }

    public void addToInbounds(Flight flight) {
        this.inbounds.add(flight);
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }


    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
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
        fare = (Fare) in.readValue(Fare.class.getClassLoader());
        resultId = in.readByte() == 0x00 ? null : in.readInt();
        adults = in.readByte() == 0x00 ? null : in.readInt();
        children = in.readByte() == 0x00 ? null : in.readInt();
        infants = in.readByte() == 0x00 ? null : in.readInt();
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
        dest.writeValue(fare);
        if (resultId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(resultId);
        }
        if (adults == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(adults);
        }
        if (children == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(children);
        }
        if (infants == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(infants);
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