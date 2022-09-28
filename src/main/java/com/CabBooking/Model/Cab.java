package com.CabBooking.Model;

public class Cab {
    private String  id;
    private String cabNumber;
    private Driver driver;
    private boolean isAvailable;
    private Location location;
    private CabStatus status;
    private Trip trip;

    public Cab(String id, String cabNumber, Driver driver, boolean isAvailable, Location location) {
        this.id = id;
        this.cabNumber = cabNumber;
        this.driver = driver;
        this.isAvailable = isAvailable;
        this.location = location;
        this.status = CabStatus.AVAILABLE;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CabStatus getStatus() {
        return status;
    }

    public void setStatus(CabStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                ", cabNumber='" + cabNumber + '\'' +
                ", driver=" + driver +
                ", isAvailable=" + isAvailable +
                ", location=" + location +
                '}';
    }
}
