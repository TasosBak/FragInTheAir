package com.example.admin.fragintheair;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Admin on 25/12/2016.
 */
public class Result implements Parcelable {

    String currency;

    ArrayList<Itinerary> itineraries = null;

    //fare
    String totalPrice;

    //adult
    String adultTotalFare;
    String adultTax;

    //infant
    String infantTotalFare;
    String infantTax;

    //restrictions
    Boolean refundableBoolean;
    Boolean changePenaltiesBoolean;

    public Result() {}

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

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAdultTotalFare() {
        return adultTotalFare;
    }

    public void setAdultTotalFare(String adultTotalFare) {
        this.adultTotalFare = adultTotalFare;
    }

    public String getAdultTax() {
        return adultTax;
    }

    public void setAdultTax(String adultTax) {
        this.adultTax = adultTax;
    }

    public String getInfantTotalFare() {
        return infantTotalFare;
    }

    public void setInfantTotalFare(String infantTotalFare) {
        this.infantTotalFare = infantTotalFare;
    }

    public String getInfantTax() {
        return infantTax;
    }

    public void setInfantTax(String infantTax) {
        this.infantTax = infantTax;
    }

    public Boolean getRefundableBoolean() {
        return refundableBoolean;
    }

    public void setRefundableBoolean(Boolean refundableBoolean) {
        this.refundableBoolean = refundableBoolean;
    }

    public Boolean getChangePenaltiesBoolean() {
        return changePenaltiesBoolean;
    }

    public void setChangePenaltiesBoolean(Boolean changePenaltiesBoolean) {
        this.changePenaltiesBoolean = changePenaltiesBoolean;
    }

    protected Result(Parcel in) {
        currency = in.readString();
        if (in.readByte() == 0x01) {
            itineraries = new ArrayList<Itinerary>();
            in.readList(itineraries, Itinerary.class.getClassLoader());
        } else {
            itineraries = null;
        }
        totalPrice = in.readString();
        adultTotalFare = in.readString();
        adultTax = in.readString();
        infantTotalFare = in.readString();
        infantTax = in.readString();
        byte refundableBooleanVal = in.readByte();
        refundableBoolean = refundableBooleanVal == 0x02 ? null : refundableBooleanVal != 0x00;
        byte changePenaltiesBooleanVal = in.readByte();
        changePenaltiesBoolean = changePenaltiesBooleanVal == 0x02 ? null : changePenaltiesBooleanVal != 0x00;
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
        dest.writeString(totalPrice);
        dest.writeString(adultTotalFare);
        dest.writeString(adultTax);
        dest.writeString(infantTotalFare);
        dest.writeString(infantTax);
        if (refundableBoolean == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (refundableBoolean ? 0x01 : 0x00));
        }
        if (changePenaltiesBoolean == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (changePenaltiesBoolean ? 0x01 : 0x00));
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
