package com.launchcode.bowling.controllers;

import com.launchcode.bowling.models.Score;
import com.launchcode.bowling.models.data.ScoreRepository;
import com.launchcode.bowling.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
//@RequestMapping(value = "score")
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

    @PostMapping("add")
    public String processAddScoreForm(@ModelAttribute @Valid Score newScore,
                                      Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        scoreRepository.save(newScore);
        return "redirect:";
    }
}
