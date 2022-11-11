package com.launchcode.bowling.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class KatController {
    @GetMapping("KP Test")
    @ResponseBody
    public String test2() {
        return "Kat's Branch Attempt";
    }
};

