package com.CabBooking.Controllers;

import com.CabBooking.Model.Cab;
import com.CabBooking.Model.Location;
import com.CabBooking.Model.Trip;
import com.CabBooking.Model.User;
import com.CabBooking.Service.CabService;
import com.CabBooking.Service.TripServices;

import java.util.List;

public class TripController {

    private CabService cabService;

    private TripServices tripServices;

    public TripController(CabService cabService, TripServices tripServices) {
        this.cabService = cabService;
        this.tripServices = tripServices;
    }

    public Trip bookCab(User user, Location source, Location destination) {
        return tripServices.bookCab(user, source, destination);
    }

    public void endTrip(Cab cab) throws Exception {
        tripServices.endTrip(cab);
    }

    public List<Trip> tripHistory(User user) {
        return tripServices.tripHistory(user);
    }
}
