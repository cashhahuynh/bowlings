package com.launchcode.bowling.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Score extends AbstractEntity {

//    @Size(max=300)
//    @Size (max = 300, message = "Score must be 300 or lower!")
    private Integer score;

//    @ManyToMany
////    @ElementCollection

//    (mappedBy = "scores")
//    private List<User> users = new ArrayList<>();
    @ManyToOne
    private User user;


    public Score(){}

    public Score(Integer score, User user) {
        this.score = score;
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return score.toString();
    }
}
