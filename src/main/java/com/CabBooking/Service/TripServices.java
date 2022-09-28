package com.CabBooking.Service;

import com.CabBooking.Model.*;
import com.CabBooking.Utils.TripUtils;

import java.lang.reflect.Array;
import java.util.*;

public class TripServices {

    private CabService cabService;

    private TripUtils tripUtils;

    public TripServices(CabService cabService, TripUtils tripUtils) {
        this.cabService = cabService;
        this.tripUtils = tripUtils;
    }

    private Map<String, List<Trip>> trips = new HashMap<>();

    public Trip bookCab(User user, Location source, Location destination) {
        List<Cab> availableCabs = cabService.getAvailableCabs(source);
        Cab selectedCab = tripUtils.selectCab(availableCabs);
        if(Objects.isNull(selectedCab)) throw new RuntimeException("No cab available");
        double price = tripUtils.calculatePrice(source, destination);
        Trip newTrip = new Trip(UUID.randomUUID().toString(), user, selectedCab, source, destination, TripStatus.IN_PROGRESS, price);
        selectedCab.setTrip(newTrip);
        if (!trips.containsKey(user.getId())) {
            trips.put(user.getId(), new ArrayList<>());
        }
        trips.get(user.getId()).add(newTrip);
        return newTrip;
    }

    public void endTrip(Cab cab) throws Exception {
        if (Objects.isNull(cab.getTrip())) throw new RuntimeException("No trip found for cab");
        cab.getTrip().setTripStatus(TripStatus.COMPLETED);
        cab.setTrip(null);
    }

    public List<Trip> tripHistory(User user) {
        return trips.get(user.getId());
    }
}
