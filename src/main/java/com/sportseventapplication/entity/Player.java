package com.sportseventapplication.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="tblplayer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String playerName;
	private int age;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Position position;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="team_Id")
	private Team team;
	
	public Player(String playerName) {
		
		this.playerName = playerName;
	}
	
	

	
}
