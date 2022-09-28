package com.CabBooking;

import com.CabBooking.Controllers.CabController;
import com.CabBooking.Controllers.TripController;
import com.CabBooking.Controllers.UserController;
import com.CabBooking.Model.Cab;
import com.CabBooking.Model.Location;
import com.CabBooking.Model.Trip;
import com.CabBooking.Model.User;
import com.CabBooking.Service.CabService;
import com.CabBooking.Service.DriverService;
import com.CabBooking.Service.TripServices;
import com.CabBooking.Service.UserService;
import com.CabBooking.Utils.TripUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCases {

    private CabController cabController;
    private TripController tripController;
    private UserController userController;

    @BeforeEach
    public void setUp() {
        CabService cabService = new CabService();
        TripUtils tripUtils = new TripUtils();
        DriverService driverService = new DriverService();
        TripServices tripServices = new TripServices(cabService, tripUtils);
        UserService userService = new UserService();

        cabController = new CabController(cabService, driverService);
        tripController = new TripController(cabService, tripServices);
        userController = new UserController(userService);
    }

    @Test
    void testBookingCab() throws Exception {
        User user1 = userController.registerRider("Shubham Shukla", "ss@gmail.com");
        User user2 = userController.registerRider("Saurabh Shukla", "svjss@gmail.com");

        Cab cab1 = cabController.registerCab("UP_65_AC_2384", "ABC", "9298392", 9, 11);
        Cab cab2 = cabController.registerCab("UP_65_AC_2385", "XYZ", "9277222", 89, 91);

        System.out.println("*****Users*****");
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println("***************");

        System.out.println("*****Cabs*****");
        System.out.println(cab1.toString());
        System.out.println(cab2.toString());
        System.out.println("***************");

        System.out.println("*****Change Location*****");
        cabController.updateCabLocation("UP_65_AC_2384", 90, 90);
        System.out.println(cab1.toString());

        System.out.println("*****Switch Availability*****");
        List<Cab> availableCabs = cabController.getAvailableCabs(new Location(92, 92));
        Assertions.assertEquals(availableCabs.size(), 2);
        cabController.switchAvailability("9298392");
        List<Cab> availableCabs2 = cabController.getAvailableCabs(new Location(92, 92));
        Assertions.assertEquals(availableCabs2.size(), 1);

        Trip trip = tripController.bookCab(user1, new Location(92.0, 92.0), new Location(96, 95));
        tripController.endTrip(trip.getCab());
        List<Trip> tripHistoryOfUser1 = tripController.tripHistory(user1);
        System.out.println(tripHistoryOfUser1.toString());
        Assertions.assertEquals(tripHistoryOfUser1.size(), 1);
    }
}
