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

import com.sportseventapplication.entity.Team;
import com.sportseventapplication.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@PostMapping
	public Team postMethodName(@RequestBody Team team) {
				
		return teamService.createTeam(team);
	}
	
	@GetMapping("/{id}")
	public Team getMethodName(@PathVariable Long id ) {
		return teamService.getTeam(id);
	}
	
	@GetMapping("/getAll")
	public List<Team> getMethodName() {
		return teamService.getAllTeam();
	}
	
	@PutMapping("/{id}")
	public Team putMethodName(@PathVariable Long id, @RequestBody Team team) {
		
		return teamService.updateTeam(team,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTeam(@PathVariable Long id) {
		teamService.deleteTeam(id);
	}
}

