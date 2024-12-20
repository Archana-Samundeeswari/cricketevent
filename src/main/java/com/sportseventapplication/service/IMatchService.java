package com.sportseventapplication.service;

import java.util.List;

import com.sportseventapplication.DTO.MatchDTO;
import com.sportseventapplication.entity.Match;

public interface IMatchService {
	public MatchDTO createMatch(Match match);
	public List<Match> getAllMatch();
	public Match getMatch(Long id);
	public MatchDTO updateMatch(Match match, Long id);
	public void deleteMatch(Long id);
}
