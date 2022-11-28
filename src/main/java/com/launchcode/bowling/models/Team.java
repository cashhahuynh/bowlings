package com.launchcode.bowling.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends AbstractEntity {

    @NotNull
    @NotBlank
    @Size(min=3, message="The team member's first name has to have a minimum of three characters.")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min=3, message ="The team member's last name has to have a minimum of three characters.")
    private String lastName;

    //11/28 addition
    @OneToMany()
    @JoinColumn(name = "score_id")
    private final List<Score> scores = new ArrayList<>();

    public Team () {};

    public Team (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override //revisit this
    public String toString() {
        return firstName + lastName;
    }
}
