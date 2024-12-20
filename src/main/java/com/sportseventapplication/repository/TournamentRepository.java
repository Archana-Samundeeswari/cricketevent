package com.sportseventapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long>{
	
	public Optional<Tournament> findByName(String name);
	
}
