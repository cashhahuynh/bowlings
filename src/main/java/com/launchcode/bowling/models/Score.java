package com.launchcode.bowling.models;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Score extends AbstractEntity {

//    @Size(max=300)
    private Integer score;

//    @OneToMany(mappedBy = "score")
    @ElementCollection
    private final List<User> users = new ArrayList<>();

    public Score(){}

    public Score(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return score.toString();
    }
}
