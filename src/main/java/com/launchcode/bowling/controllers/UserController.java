package com.launchcode.bowling.controllers;

import com.launchcode.bowling.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "register")
    public String register() {
        return "user/register";
    }

    @GetMapping(value = "homepage")
    public String homepage() {
        return "user/homepage";
    }

}
