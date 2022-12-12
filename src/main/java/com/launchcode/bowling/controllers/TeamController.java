package com.launchcode.bowling.controllers;

import com.launchcode.bowling.models.Team;
import com.launchcode.bowling.models.User;
import com.launchcode.bowling.models.data.TeamRepository;
import com.launchcode.bowling.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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

    @PostMapping("")
    private String displayTeam(@ModelAttribute @Valid Team team,
                               Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "addTeam";
        }

        teamRepository.save(team);
        model.addAttribute("teams", teamRepository.findAll());

        return "/view";
    }

    @GetMapping("view")
    private String index(@RequestParam(defaultValue = "193") Integer userId, Model model) {

        if (userId == null) {
            model.addAttribute("title", "Invalid Id: " + userId);
            model.addAttribute("teams", teamRepository.findAll());
            model.addAttribute("read", "reads if (userId == null) statement");
        } else {
            model.addAttribute("read", "reads else statement");
            Optional<User> result = userRepository.findById(userId);
            if (result.isEmpty()) {
                model.addAttribute("read", "reads if (result.isEmpty()) statement");
                model.addAttribute("title", "Invalid User Id");
            } else {
                model.addAttribute("read", "reads second else statement");
                User user = result.get();
                model.addAttribute("users", user.getUsername());
            }
        }

        model.addAttribute("teams", teamRepository.findAll());
        return "view";
    }

}