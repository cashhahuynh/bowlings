package com.launchcode.bowling.models.data;

import com.launchcode.bowling.models.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ScoreRepository extends CrudRepository<Score, Integer> {

}

