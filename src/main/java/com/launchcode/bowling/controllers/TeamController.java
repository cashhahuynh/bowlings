package com.launchcode.bowling.controllers;

import com.launchcode.bowling.models.Team;
import com.launchcode.bowling.models.data.TeamRepository;
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
@RequestMapping(value = "team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("")
    private String addTeamDisplay(Model model) {
        model.addAttribute(new Team());
        return "addTeam";
    }

    @PostMapping("")
    private String displayTeam(@ModelAttribute @Valid Team newTeam,
                               Errors errors) {

        if (errors.hasErrors()) {
            return "addTeam";
        }

        teamRepository.save(newTeam);

        return "redirect:";
    }

    @GetMapping("view")
    private String index(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        return "view";
    }

    // thinking about view for team member profile with scores and usernames.
    // thomas might need to include a dropdown of current team members that have been created in order to submit scores?
    // one score can be associated with multiple team members. one to many relationship?

}
