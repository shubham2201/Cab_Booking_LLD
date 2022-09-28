package com.CabBooking.Service;

import com.CabBooking.Model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DriverService {

    List<Driver> drivers = new ArrayList<>();

    public Driver saveAndGetDriver(String name, String email) {
        return drivers.stream().filter(driver -> driver.getEmail().equals(email)).findAny()
                .orElseGet(() -> registerDriver(name, email));
    }

    public Driver registerDriver(String name, String email) {
        if(drivers.stream().anyMatch(user -> user.getEmail().equals(email))) {
            throw new RuntimeException("Driver already exist");
        }
        Driver driver = new Driver(UUID.randomUUID().toString(), name, email);
        drivers.add(driver);
        return driver;
    }

    public Driver getDriver(String email) {
        return drivers.stream().filter(driver -> driver.getEmail().equals(email)).findAny()
                .orElseThrow(() -> new RuntimeException("Invalid Driver"));
    }
}
