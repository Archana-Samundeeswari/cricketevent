package com.sportseventapplication.service;

import java.util.List;
import java.util.Optional;

import com.sportseventapplication.entity.Team;

public interface ITeamService {
	public Team createTeam(Team team);
	public List<Team> getAllTeam();
	public Team getTeam(Long id);
	public Team updateTeam(Team team, Long id);
	public void deleteTeam(Long id);
	public Optional<Team> findByteamName(String teamName);

}
