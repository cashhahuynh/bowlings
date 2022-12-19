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

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("view")
    private String index(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "team/view";
    }

    @GetMapping("assignTeam")
    private String assignTeamDisplay(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "team/assignTeam";
    }

    @PostMapping("assignTeam")
    private String assignTeam(@ModelAttribute @Valid Team team,
                              Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "team/assignTeam";
        }

        teamRepository.save(team);
        model.addAttribute("teams", teamRepository.findAll());

        return "team/view";
    }

    @GetMapping("createTeam")
    private String createTeamDisplay(Model model) {
        model.addAttribute(new Team());
        model.addAttribute("users", userRepository.findAll());
        return "team/createTeam";
    }


    @PostMapping("createTeam")
    private String createTeam(@ModelAttribute @Valid Team team,
                               Errors errors, Model model) {

//        if (errors.hasErrors()) {
//            model.addAttribute("users", userRepository.findAll());
//            return "team/createTeam";
//        }

        teamRepository.save(team);
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "team/view";
    }



//    @GetMapping("view")
//    private String index(@RequestParam(defaultValue = "") Integer teamId, Model model) {
//
//        if (teamId == null) {
//            model.addAttribute("title", "Invalid Id: " + teamId);
//            model.addAttribute("teams", teamRepository.findAll());
//            model.addAttribute("read", "reads if (userId == null) statement");
//        } else {
//            model.addAttribute("read", "reads else statement");
//            Optional<User> result = userRepository.findById(teamId);
//            if (result.isEmpty()) {
//                model.addAttribute("read", "reads if (result.isEmpty()) statement");
//                model.addAttribute("title", "Invalid User Id");
//            } else {
//                model.addAttribute("read", "reads second else statement");
//                User user = result.get();
//                model.addAttribute("users", user.getUsername());
//            }
//        }
//
//        model.addAttribute("teams", teamRepository.findAll());
//        return "view";
//    }


}


//    @RequestParam(required = false) Integer teamId,
//    @PostMapping("") //user isn't being selected for team. think requestparam is teamId...? changed class type from user to team.
//    private String displayTeam(@ModelAttribute @Valid Team newTeam,
//                               Errors errors, @RequestParam(required = false) Integer teamId, Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add teams");
//            return "addTeam";
//        }
//
//        if (teamId == null) {
//            model.addAttribute("title", "All teams");
//            model.addAttribute("teams", teamRepository.findAll());
//        } else {
//            Optional<Team> result = teamRepository.findById(teamId);
//            if (result.isEmpty()) {
//                model.addAttribute("title", "Invalid id.");
//            } else {
//                Team team = result.get();
//                model.addAttribute("title", "Team in category: " + newTeam.getName());
//                model.addAttribute("team", newTeam.getUsers());
//            }
//        }
//
//        teamRepository.save(newTeam);
//
//        return "/view";
//    }