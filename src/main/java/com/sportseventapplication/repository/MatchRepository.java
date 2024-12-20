package com.sportseventapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.Match;

public interface MatchRepository extends JpaRepository<Match,Long> {

}
