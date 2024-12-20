package com.sportseventapplication.service;

import java.util.List;
import java.util.Optional;

import com.sportseventapplication.entity.Player;

public interface IPlayerService {
	public Player createPlayer(Player player);
	public List<Player> getAllPlayer();
	public Player getPlayer(Long id);
	public Player updatePlayer(Player player, Long id);
	public void deletePlayer(Long id);
	public Optional<Player> findByPlayerName(String playerName);

}
