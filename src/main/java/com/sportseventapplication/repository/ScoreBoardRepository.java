package com.sportseventapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.ScoreBoard;

public interface ScoreBoardRepository extends JpaRepository<ScoreBoard, Long>{

}
