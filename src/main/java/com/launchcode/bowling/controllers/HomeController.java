package com.launchcode.bowling.controllers;

import com.launchcode.bowling.models.User;
import com.launchcode.bowling.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController { //home controller is not going to be storing new objects. testing.

    @Autowired
    private UserRepository userRepository;

//    private UserController userController; //used this for return statement

    @GetMapping(value = "")
    public String landingPage() {
        return "index";
    }

    @PostMapping(value = "") //need to have user registration set up to compare against User object before advancing to homepage.
    public String processLogin(@ModelAttribute @Valid User user, Errors errors) { //validation dependency included
        if (errors.hasErrors()) { //when i provide value for action attribute it ignores this and sends anyway?...found out it will prioritize return here though...
            return "index";
        }

        userRepository.save(user);

        return "redirect:"; //tried testing redirecting to value, not path to template
    }

//    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
//    public String processLogin() {
//        return "index";
//    }

    //want to return something to user/homepage

    @GetMapping(value = "register")
    public String register() {
        return "registrationType";
    }

}
