package com.sportseventapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.Tournament;
import com.sportseventapplication.repository.TeamRepository;
import com.sportseventapplication.repository.TournamentRepository;

@Service
public class TournamentService implements ITournamentService{
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
	
	@Override
	public Tournament createTournament(Tournament tournament) {
		
		return  tournamentRepository.save(tournament);
	}

	@Override
	public List<Tournament> getAllTournament() {
		
		return  tournamentRepository.findAll();
	}

	@Override
	public Tournament getTournament(Long id) {
		
		return tournamentRepository.findById(id).get();
	}

	@Override
	public Tournament updateTournament(Tournament tournament, Long id) {
		tournament.setId(id);
		return  tournamentRepository.save(tournament);
	}

	@Override
	public void deleteTournament(Long id) {
		 tournamentRepository.deleteById(id);
		
	}

	@Override
	public Optional<Tournament> findByName(String name) {
		// TODO Auto-generated method stub
		return tournamentRepository.findByName(name);
	}
	

}
