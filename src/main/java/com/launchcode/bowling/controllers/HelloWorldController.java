package com.launchcode.bowling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping(value = "bowl")
    public String welcome() {
        return "LaunchBowl";
    }
}
