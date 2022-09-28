package com.CabBooking.Utils;

import com.CabBooking.Model.Cab;
import com.CabBooking.Model.Location;

import java.util.List;

public class TripUtils {

    public Cab selectCab(List<Cab> cabs) {
        if (cabs.size() == 0) return null;
        return cabs.get(0);

        // Logic to select cab
    }

    public double calculatePrice(Location source, Location destination) {
        return CabBookingConstants.fixedPrice + source.getDistance(destination) * CabBookingConstants.pricePerKm;
    }
}
