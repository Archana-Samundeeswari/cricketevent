package com.sportseventapplication.service;

import java.util.List;
import java.util.Optional;

import com.sportseventapplication.entity.Tournament;

public interface ITournamentService {
	public Tournament createTournament(Tournament tournament);
	public List<Tournament> getAllTournament();
	public Tournament getTournament(Long id);
	public Tournament updateTournament(Tournament tournament, Long id);
	public void deleteTournament(Long id);
	public Optional<Tournament> findByName(String name);
}
