package com.launchcode.bowling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

=======

@Controller
public class HelloWorldController {
>>>>>>> added MySQL connections
    @GetMapping(value = "")
    public String welcome() {
        return "hello";
    }
<<<<<<< HEAD

=======
>>>>>>> added MySQL connections
}
