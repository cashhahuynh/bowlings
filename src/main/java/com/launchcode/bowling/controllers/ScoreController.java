package com.launchcode.bowling.controllers;

import com.launchcode.bowling.models.Score;
import com.launchcode.bowling.models.User;
import com.launchcode.bowling.models.data.ScoreRepository;
import com.launchcode.bowling.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ScoreController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreRepository scoreRepository;

//    @GetMapping("")
//    private String addScoreDisplay(Model model) {
//        model.addAttribute(new Score());
//        model.addAttribute("users", userRepository.findAll());
//        return "add";
//    }

        @GetMapping("add")
    public String displayAddScoreForm(Model model) {
        model.addAttribute(new Score());
        model.addAttribute("users", userRepository.findAll());
        return "add";
    }

//    @RequestParam Integer userId)

    @PostMapping("add")
    public String processAddScoreForm(@ModelAttribute @Valid Score newScore,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Score");
            return "add";
        }
//        else {
//            User newUser = userRepository.findByUsername(registerFormDTO.getUsername()).orElse(new User());
//            newUser.setUser(newUser);
//
//        }

        scoreRepository.save(newScore);
        return "/add";
    }
}
