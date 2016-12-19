package com.example.admin.fragintheair;

/**
 * Created by Admin on 19/12/2016.
 */

public class FlightObject {
    String departsAt;
    String arrivesAt;

    String originAirport;
    String originTerminal;

    String destinationMarketingAirline;
    String destinationOperatingAirline;
    String destinationFlightNumber;
    String destinationAircraft;

    String bookingInfoTravelClass;
    String bookingInfoBookingCode;
    String bookingInfoSeatsRemaining;

    String totalPrice;

    String adultTotalFare;
    String adultTax;

    Boolean refundableBoolean;
    Boolean changePenaltiesBoolean;

    String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

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

    public String getDestinationMarketingAirline() {
        return destinationMarketingAirline;
    }

    public void setDestinationMarketingAirline(String destinationMarketingAirline) {
        this.destinationMarketingAirline = destinationMarketingAirline;
    }

    public String getDestinationOperatingAirline() {
        return destinationOperatingAirline;
    }

    public void setDestinationOperatingAirline(String destinationOperatingAirline) {
        this.destinationOperatingAirline = destinationOperatingAirline;
    }

    public String getDestinationFlightNumber() {
        return destinationFlightNumber;
    }

    public void setDestinationFlightNumber(String destinationFlightNumber) {
        this.destinationFlightNumber = destinationFlightNumber;
    }

    public String getDestinationAircraft() {
        return destinationAircraft;
    }

    public void setDestinationAircraft(String destinationAircraft) {
        this.destinationAircraft = destinationAircraft;
    }

    public String getBookingInfoTravelClass() {
        return bookingInfoTravelClass;
    }

    public void setBookingInfoTravelClass(String bookingInfoTravelClass) {
        this.bookingInfoTravelClass = bookingInfoTravelClass;
    }

    public String getBookingInfoBookingCode() {
        return bookingInfoBookingCode;
    }

    public void setBookingInfoBookingCode(String bookingInfoBookingCode) {
        this.bookingInfoBookingCode = bookingInfoBookingCode;
    }

    public String getBookingInfoSeatsRemaining() {
        return bookingInfoSeatsRemaining;
    }

    public void setBookingInfoSeatsRemaining(String bookingInfoSeatsRemaining) {
        this.bookingInfoSeatsRemaining = bookingInfoSeatsRemaining;
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
}
