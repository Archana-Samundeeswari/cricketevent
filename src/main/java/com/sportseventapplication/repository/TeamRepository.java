package com.sportseventapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{
	public Optional<Team> findByteamName(String teamName);

}
