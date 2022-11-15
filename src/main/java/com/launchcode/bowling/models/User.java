package com.launchcode.bowling.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {

    @NotNull
    @NotBlank
    @Size(min=5, message="Username has to have a minimum of five characters.")
    private String username;

    @NotNull
    @NotBlank
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}
