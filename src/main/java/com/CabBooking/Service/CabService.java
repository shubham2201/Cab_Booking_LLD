package com.CabBooking.Service;

import com.CabBooking.Model.Cab;
import com.CabBooking.Model.CabStatus;
import com.CabBooking.Model.Driver;
import com.CabBooking.Model.Location;
import com.CabBooking.Utils.CabBookingConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CabService {

    private List<Cab> cabs = new ArrayList<>();

    public Cab registerCab(String cabNumber, Driver driver, Location location) {
        Cab cab = new Cab(UUID.randomUUID().toString(), cabNumber, driver, true, location);
        cabs.add(cab);
        return cab;
    }

    public void updateLocation(String cabNumber, int lat, int logi) {
        Cab savedCab = cabs.stream().filter(cab -> cab.getCabNumber().equals(cabNumber)).findAny()
                .orElseThrow(() -> new RuntimeException("Cab not found"));
        savedCab.setLocation(new Location(lat, logi));
    }

    public void switchAvailability(Driver driver) {
        Cab driverCab = cabs.stream().filter(cab -> cab.getDriver().getId().equals(driver.getId())).findAny()
                .orElseThrow(() -> new RuntimeException("No cab found for driver"));
        driverCab.setAvailable(!driverCab.isAvailable());
    }

    public List<Cab> getAvailableCabs(Location userLocation) {
        return cabs.stream()
                .filter(cab -> CabStatus.AVAILABLE.equals(cab.getStatus()) && cab.isAvailable() &&
                        Math.sqrt(Math.pow(cab.getLocation().getX() - userLocation.getX(), 2) +
                                Math.pow(cab.getLocation().getY() - userLocation.getY(), 2)) <= CabBookingConstants.maxDistanceDriverCanTravel)
                .collect(Collectors.toList());
    }
}
