package com.launchcode.bowling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "")
    public String homepage() {
        return "index";
    }

    @GetMapping(value = "register")
    public String register() {
        return "registrationType";
    }
}
