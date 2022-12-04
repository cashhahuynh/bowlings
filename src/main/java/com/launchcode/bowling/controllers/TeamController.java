package com.launchcode.bowling.controllers;

import com.launchcode.bowling.models.Team;
import com.launchcode.bowling.models.data.TeamRepository;
import com.launchcode.bowling.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    private String addTeamDisplay(Model model) {
        model.addAttribute(new Team());
        model.addAttribute("users", userRepository.findAll());
        return "addTeam";
    }

    @PostMapping("") //user isn't being selected for team. think requestparam is teamId...? changed class type from user to team.
    private String displayTeam(@ModelAttribute @Valid Team newTeam,
                               Errors errors, @RequestParam(required = false) Integer teamId, Model model) {

        if (errors.hasErrors()) {
            return "addTeam";
        }

        if (teamId == null) {
            model.addAttribute("title", "All teams");
            model.addAttribute("teams", teamRepository.findAll());
        } else {
            Optional<Team> result = teamRepository.findById(teamId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid id.");
            } else {
                Team team = result.get();
                model.addAttribute("title", "Team in category: " + newTeam.getName());
                model.addAttribute("team", newTeam.getUsers());
            }
        }

        teamRepository.save(newTeam);

        return "/view";
    }

    @GetMapping("view")
    private String index(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        return "view";
    }


}
