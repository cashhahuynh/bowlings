package com.launchcode.bowling.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractEntity{

    @Id
    @GeneratedValue
    private int id;

    public Admin() {}

}
