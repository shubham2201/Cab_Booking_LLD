package com.CabBooking.Service;

import com.CabBooking.Model.Driver;
import com.CabBooking.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {

    private List<User> users = new ArrayList<>();

    public User registerUsers(String name, String email) {
        if(users.stream().anyMatch(user -> user.getEmail().equals(email))) {
            throw new RuntimeException("User exist");
        }
        User user = new User(UUID.randomUUID().toString(), name, email);
        users.add(user);
        return user;
    }
}
