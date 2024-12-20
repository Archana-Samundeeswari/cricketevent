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

import com.sportseventapplication.entity.Player;
import com.sportseventapplication.service.PlayerService;

@RestController
@RequestMapping("players")
public class PlayerController {
	@Autowired
	private PlayerService playerService;
	
	@PostMapping
	public Player postMethodName(@RequestBody Player player) {
				
		return playerService.createPlayer(player);
	}
	
	@GetMapping("/{id}")
	public Player getMethodName(@PathVariable Long id ) {
		return playerService.getPlayer(id);
	}
	
	@GetMapping("/getAll")
	public List<Player> getMethodName() {
		return playerService.getAllPlayer();
	}
	
	@PutMapping("/{id}")
	public Player putMethodName(@PathVariable Long id, @RequestBody Player player) {
		
		return playerService.updatePlayer(player,id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable Long id) {
		playerService.deletePlayer(id);
	}
}
