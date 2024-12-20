package com.sportseventapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.DTO.MatchDTO;
import com.sportseventapplication.entity.Match;
import com.sportseventapplication.entity.Team;
import com.sportseventapplication.entity.Tournament;
import com.sportseventapplication.exception.UserNotFoundException;
import com.sportseventapplication.repository.MatchRepository;
import com.sportseventapplication.repository.TeamRepository;
import com.sportseventapplication.repository.TournamentRepository;
import com.sportseventapplication.response.ResponseApi;

@Service
public class MatchService implements IMatchService{
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
	@Override
	public MatchDTO createMatch(Match match) {
		
		Match savedMatch = matchRepository.save(match);
		
		Team team1 = teamRepository.findByteamName(match.getTeam1().getTeamName()).get();
		match.setTeam1(team1);
		
		Tournament existingTournament = tournamentRepository.findByName(match.getTournament().getName())
				.orElseThrow(
				()->{throw new UserNotFoundException("Tournament not found");
				});
		
		
		Team team2 = teamRepository.findByteamName(match.getTeam2().getTeamName()).get();
		match.setTeam2(team2);
		

		
		
		return convertToDTO(savedMatch);
	}

	@Override
	public List<Match> getAllMatch() {
		
		return matchRepository.findAll();
	}

	@Override
	public Match getMatch(Long id) {
		
		return matchRepository.findById(id).get();
	}

	@Override
	public MatchDTO updateMatch(Match match, Long id) {
		
				
		Match updateMatch= matchRepository.findById(id).orElseThrow(()->{
			throw new UserNotFoundException("User Not Found");
		});	
		//return convertToDTO(matchRepository.save(updateMatch));
		return createMatch(updateMatch);
	}

	@Override
	public void deleteMatch(Long id) {
		matchRepository.deleteById(id);
	}
	
	public MatchDTO convertToDTO(Match match) {
		return new MatchDTO(match.getId(),match.getName(),match.getTeam1().getTeamName(),match.getTeam2().getTeamName(),match.getTournament().getName());
		
	}
}
