package com.sportseventapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.Player;
import com.sportseventapplication.entity.Team;
import com.sportseventapplication.repository.PlayerRepository;
import com.sportseventapplication.repository.TeamRepository;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Player createPlayer(Player player) {
		if (player.getTeam() != null) {
			Team team = teamRepository.findByteamName(player.getTeam().getTeamName()).get();
			player.setTeam(team);
		}
		return playerRepository.save(player);
	}

	@Override
	public List<Player> getAllPlayer() {

		return playerRepository.findAll();
	}

	@Override
	public Player getPlayer(Long id) {

		return playerRepository.findById(id).get();
	}

	@Override
	public Player updatePlayer(Player player, Long id) {
		player.setId(id);
		return playerRepository.save(player);
	}

	@Override
	public void deletePlayer(Long id) {
		playerRepository.deleteById(id);
	}

	@Override
	public Optional<Player> findByPlayerName(String playerName) {

		return playerRepository.findByplayerName(playerName);
	}

}
