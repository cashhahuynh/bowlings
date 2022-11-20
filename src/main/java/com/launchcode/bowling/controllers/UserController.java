package com.launchcode.bowling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("register")
public class UserController {

    @GetMapping(value = "user")
    public String register() {
        return "user/register";
    }
}

