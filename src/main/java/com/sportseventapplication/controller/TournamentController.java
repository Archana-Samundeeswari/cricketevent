package com.sportseventapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportseventapplication.entity.Tournament;
import com.sportseventapplication.service.TournamentService;

@RestController
@RequestMapping("tournament")
public class TournamentController {
	@Autowired
	private TournamentService tournamentService;
	
	@PostMapping
	public Tournament postMethodName(@RequestBody Tournament tournament) {
				
		return tournamentService.createTournament(tournament);
	}
	
	@GetMapping("/{id}")
	public Tournament getMethodName(@PathVariable Long id ) {
		return tournamentService.getTournament(id);
	}
	
	@GetMapping("/getAll")
	public List<Tournament> getMethodName() {
		return tournamentService.getAllTournament();
	}
	
	@PutMapping("/{id}")
	public Tournament putMethodName(@PathVariable Long id, @RequestBody Tournament tournament) {
		
		return tournamentService.updateTournament(tournament,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTournament(@PathVariable Long id) {
		tournamentService.deleteTournament(id);
	}
}

