package com.example.admin.fragintheair;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 25/12/2016.
 */
public class Flight implements Parcelable {

    String departsAt;
    String arrivesAt;

    //origin
    String originAirport;
    String originTerminal;

    //destination
    String destinationAirport;

    String marketingAirline;
    String operatingAirline;
    String flightNumber;
    String aircraft;

    //booking_info
    String travelClass;
    String bookingCode;
    String seatsRemaining;

    public Flight() {}

    public String getDepartsAt() {
        return departsAt;
    }

    public void setDepartsAt(String departsAt) {
        this.departsAt = departsAt;
    }

    public String getArrivesAt() {
        return arrivesAt;
    }

    public void setArrivesAt(String arrivesAt) {
        this.arrivesAt = arrivesAt;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getOriginTerminal() {
        return originTerminal;
    }

    public void setOriginTerminal(String originTerminal) {
        this.originTerminal = originTerminal;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getMarketingAirline() {
        return marketingAirline;
    }

    public void setMarketingAirline(String marketingAirline) {
        this.marketingAirline = marketingAirline;
    }

    public String getOperatingAirline() {
        return operatingAirline;
    }

    public void setOperatingAirline(String operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getSeatsRemaining() {
        return seatsRemaining;
    }

    public void setSeatsRemaining(String seatsRemaining) {
        this.seatsRemaining = seatsRemaining;
    }

    protected Flight(Parcel in) {
        departsAt = in.readString();
        arrivesAt = in.readString();
        originAirport = in.readString();
        originTerminal = in.readString();
        destinationAirport = in.readString();
        marketingAirline = in.readString();
        operatingAirline = in.readString();
        flightNumber = in.readString();
        aircraft = in.readString();
        travelClass = in.readString();
        bookingCode = in.readString();
        seatsRemaining = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departsAt);
        dest.writeString(arrivesAt);
        dest.writeString(originAirport);
        dest.writeString(originTerminal);
        dest.writeString(destinationAirport);
        dest.writeString(marketingAirline);
        dest.writeString(operatingAirline);
        dest.writeString(flightNumber);
        dest.writeString(aircraft);
        dest.writeString(travelClass);
        dest.writeString(bookingCode);
        dest.writeString(seatsRemaining);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Flight> CREATOR = new Parcelable.Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel in) {
            return new Flight(in);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };
}