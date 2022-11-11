package com.launchcode.bowling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> added  new test controller
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

<<<<<<< HEAD
    @GetMapping(value = "hello")
    public String welcome() {
        return "hello";
    }

=======
=======

@Controller
public class HelloWorldController {
>>>>>>> added MySQL connections
    @GetMapping(value = "")
    public String welcome() {
        return "hello";
    }
<<<<<<< HEAD

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "something";
    }

=======
>>>>>>> added MySQL connections
>>>>>>> added  new test controller
}
