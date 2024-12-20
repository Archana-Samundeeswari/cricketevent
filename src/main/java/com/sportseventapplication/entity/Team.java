package com.sportseventapplication.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_team")
@NoArgsConstructor
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String teamName;
	private String Coach;
	
	@OneToMany(mappedBy = "team")
	@JsonIgnore
	private List<Player> players = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="captain_Id")
	private Player captain;
	


	public Team(long id, String teamName, String coach, List<Player> players, Player captain) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.Coach = coach;
		this.players = players;
		this.captain = captain;
	}
	public Team(String teamName) {
		this.teamName=teamName;
	}
	
	
}
