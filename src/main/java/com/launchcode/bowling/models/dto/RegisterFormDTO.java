package com.launchcode.bowling.models.dto;

import com.launchcode.bowling.models.Team;

public class RegisterFormDTO extends LoginFormDTO {

    private String verifyPassword;

    private Team team;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
