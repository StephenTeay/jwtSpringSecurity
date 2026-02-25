package com.teay.security.controllers;

import com.teay.security.dtos.UserRequest;
import com.teay.security.models.Users;
import com.teay.security.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Users createUser(@RequestBody UserRequest request) throws Exception {
        return userService.registerUser(request);

    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequest request) {
        return userService.verifyUser(request);
    }
}
