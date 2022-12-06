package com.launchcode.bowling.models;

import javax.persistence.*;

@Entity
public class Score extends AbstractEntity {

//    @Size(max=300)
//    @Size (max = 300, message = "Score must be 300 or lower!")
    private Integer gameOneScore;

    private Integer gameTwoScore;

    private Integer gameThreeScore;

//    @ManyToMany
////    @ElementCollection

//    (mappedBy = "scores")
//    private List<User> users = new ArrayList<>();
    @ManyToOne
    private User user;


    public Score(){}

    public Score(Integer gameOneScore, Integer gameTwoScore, Integer gameThreeScore, User user) {
        this.gameOneScore = gameOneScore;
        this.gameTwoScore = gameTwoScore;
        this.gameThreeScore = gameThreeScore;
        this.user = user;
    }

    public Integer getGameOneScore() {
        return gameOneScore;
    }

    public void setGameOneScore(Integer gameOneScore) {
        this.gameOneScore = gameOneScore;
    }

    public Integer getGameTwoScore() {
        return gameTwoScore;
    }

    public void setGameTwoScore(Integer gameTwoScore) {
        this.gameTwoScore = gameTwoScore;
    }

    public Integer getGameThreeScore() {
        return gameThreeScore;
    }

    public void setGameThreeScore(Integer gameThreeScore) {
        this.gameThreeScore = gameThreeScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return gameOneScore.toString();
    }
}
