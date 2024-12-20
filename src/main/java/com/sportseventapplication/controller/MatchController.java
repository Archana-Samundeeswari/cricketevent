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

import com.sportseventapplication.DTO.MatchDTO;
import com.sportseventapplication.entity.Match;
import com.sportseventapplication.service.MatchService;

@RestController
@RequestMapping("match")
public class MatchController {
	@Autowired
	private MatchService matchService;
	
	@PostMapping
	public MatchDTO postMethodName(@RequestBody Match match) {
				
		return matchService.createMatch(match);
	}
	
	@GetMapping("/{id}")
	public Match getMethodName(@PathVariable Long id ) {
		return matchService.getMatch(id);
	}
	
	@GetMapping("/getAll")
	public List<Match> getMethodName() {
		return matchService.getAllMatch();
	}
	
	@PutMapping("/{id}")
	public MatchDTO putMethodName(@PathVariable Long id, @RequestBody Match match) {
		
		return matchService.updateMatch(match,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMatch(@PathVariable Long id) {
		matchService.deleteMatch(id);
	}
}

