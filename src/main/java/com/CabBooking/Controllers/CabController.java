package com.CabBooking.Controllers;

import com.CabBooking.Model.Cab;
import com.CabBooking.Model.Driver;
import com.CabBooking.Model.Location;
import com.CabBooking.Service.CabService;
import com.CabBooking.Service.DriverService;

import java.util.List;

public class CabController {

    private CabService cabService;

    private DriverService driverService;

    public CabController(CabService cabService, DriverService driverService) {
        this.cabService = cabService;
        this.driverService = driverService;
    }

    public Cab registerCab(String cabNumber, String driverName, String driverEmail, int x, int y) {
        Driver driver = driverService.saveAndGetDriver(driverName, driverEmail);
        return cabService.registerCab(cabNumber, driver, new Location(x, y));
    }

    public void updateCabLocation(String cabNumber, int x, int y) {
        cabService.updateLocation(cabNumber, x, y);
    }

    public void switchAvailability(String driverEmail) {
        Driver driver = driverService.getDriver(driverEmail);
        cabService.switchAvailability(driver);
    }

    public List<Cab> getAvailableCabs(Location userLocation) {
        return cabService.getAvailableCabs(userLocation);
    }
}
