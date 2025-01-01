package com.website.ecommerce.controller;

import com.website.ecommerce.entity.User;
import com.website.ecommerce.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('admin')")
    public String forAdmin() {
        return "This URL is only accessible to admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasAnyRole('user','admin')")
    public String forUser() {
        return "This URL is only accessible to user";
    }
}
