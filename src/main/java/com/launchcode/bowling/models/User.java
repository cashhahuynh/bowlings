package com.launchcode.bowling.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity{

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @ManyToOne
    private Team team;

//   @OneToMany
//    private Score score;

//    @ManyToMany
//    @JoinColumn(name = "user_id")
    @OneToMany(mappedBy = "user")
    private final List<Score> scores = new ArrayList<>();

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password, Team team) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.team = team;
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setUser(User newUser) {
    }

    public List<Score> getScores() {
        return scores;
    }
}
