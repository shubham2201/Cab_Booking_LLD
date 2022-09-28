package com.CabBooking.Controllers;

import com.CabBooking.Model.User;
import com.CabBooking.Service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User registerRider(String name, String email) {
        return userService.registerUsers(name, email);
    }
}
