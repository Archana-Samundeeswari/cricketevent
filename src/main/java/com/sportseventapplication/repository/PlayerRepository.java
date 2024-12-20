package com.sportseventapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	public Optional<Player> findByplayerName(String playerName);

}
