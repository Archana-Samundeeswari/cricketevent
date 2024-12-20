package com.sportseventapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.Player;
import com.sportseventapplication.entity.Team;
import com.sportseventapplication.repository.TeamRepository;

@Service
public class TeamService implements ITeamService{
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PlayerService playServ;
	
	@Override
	public Team createTeam(Team team) {
		if(team.getCaptain()!=null) {
			Player captain = playServ.findByPlayerName(team.getCaptain().getPlayerName()).get();
			team.setCaptain(captain);	
		}
		
		
		List<Player> players = new ArrayList<>();
		if(!team.getPlayers().isEmpty())
		{
			 players =   team.getPlayers().stream().map(player->playServ.findByPlayerName(player.getPlayerName()).get()).toList();
			 team.setPlayers(players);	
		}
		
		
		return teamRepository.save(team);
	}

	@Override
	public List<Team> getAllTeam() {
		
		return teamRepository.findAll();
	}

	@Override
	public Team getTeam(Long id) {
		
		return teamRepository.findById(id).get();
	}

	@Override
	public Team updateTeam(Team team, Long id) {
		team.setId(id);
		return teamRepository.save(team);
	}

	@Override
	public void deleteTeam(Long id) {
		teamRepository.deleteById(id);
		
	}

	@Override
	public Optional<Team> findByteamName(String teamName) {
		
		return teamRepository.findByteamName(teamName);
	}

}
