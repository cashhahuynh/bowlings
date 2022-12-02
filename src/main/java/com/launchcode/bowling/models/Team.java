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

    //something is weird here now...
    @Size(min=3, message="The team name has to have a minimum of five characters.")
    @NotNull
    @NotBlank
    private String name;

    //11/28 addition
    @OneToMany(mappedBy = "team")
    //@JoinColumn(name = "user_id") //where does this name show up?
    private final List<User> users = new ArrayList<>();

    public Team () {};

    public Team (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //12/1 addition
    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        if (!super.equals(o)) return false;

        Team team = (Team) o;

        return getName() != null ? getName().equals(team.getName()) : team.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
