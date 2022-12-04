package com.launchcode.bowling.models.data;

import com.launchcode.bowling.models.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

    //something

}