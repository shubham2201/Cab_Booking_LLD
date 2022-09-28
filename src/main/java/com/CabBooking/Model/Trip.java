package com.CabBooking.Model;

public class Trip {
    private String id;
    private User rider;
    private Cab cab;
    private Location source;
    private Location destination;
    private TripStatus tripStatus;
    private double price;

    public Trip(String id, User rider, Cab cab, Location source, Location destination, TripStatus tripStatus, double price) {
        this.id = id;
        this.rider = rider;
        this.cab = cab;
        this.source = source;
        this.destination = destination;
        this.tripStatus = tripStatus;
        this.price = price;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Cab getCab() {
        return cab;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + id + '\'' +
                ", rider=" + rider +
                ", cab=" + cab +
                ", source=" + source +
                ", destination=" + destination +
                ", tripStatus=" + tripStatus +
                ", price=" + price +
                '}';
    }
}
