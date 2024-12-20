package com.sportseventapplication.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tblMatch")
@Data
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	@ManyToOne
	@JoinColumn(name="team1_Id")
	private Team team1;
	
	@ManyToOne
	@JoinColumn(name="team2_Id")
	private Team team2;
	
	@ManyToOne
	@JoinColumn(name="tournament_Id")
	private Tournament tournament;

	public Match(long id, LocalDateTime date, String venue, int score1, int score2, String name, Status status,
			Team team1, Team team2, Tournament tournament) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Match() {
		super();
	}
	
	
	
}
