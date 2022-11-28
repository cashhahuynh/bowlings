
package com.launchcode.bowling.controllers;

import com.launchcode.bowling.models.Score;
import com.launchcode.bowling.models.data.ScoreRepository;
import com.launchcode.bowling.models.data.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("scores", scoreRepository.findAll());
        model.addAttribute("teams", teamRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddScoreForm(Model model) {
        model.addAttribute(new Score());
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

    //user will select a score when they create a new team?
    //add team data from repository
    //checkout template for name of variables
    //processAddTeamForm?...will need request param

}


