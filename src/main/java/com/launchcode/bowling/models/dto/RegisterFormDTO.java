package com.launchcode.bowling.models.dto;

import com.launchcode.bowling.models.Team;

public class RegisterFormDTO extends LoginFormDTO { //thought about mapped super class. nothing.

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof RegisterFormDTO)) return false;
//
//        RegisterFormDTO that = (RegisterFormDTO) o;
//
//        return getTeam() != null ? getTeam().equals(that.getTeam()) : that.getTeam() == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return getTeam() != null ? getTeam().hashCode() : 0;
//    }
}
