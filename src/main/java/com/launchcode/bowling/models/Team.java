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

    @Size(min=3, message="The team name has to have a minimum of five characters.")
    @NotNull
    @NotBlank
    private String name;

    @OneToMany//(mappedBy = "team") //12/7 addition
    @JoinColumn(name = "user_id")
    private List<User> users = new ArrayList<>();

    public Team () {}

    public Team (String name, List<User> aUser) {
        this.name = name;
        this.users = aUser;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
