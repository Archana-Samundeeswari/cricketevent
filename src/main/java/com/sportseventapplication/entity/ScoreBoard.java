package com.sportseventapplication.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tblScoreBoard")
@Data
public class ScoreBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(mappedBy="scoreBoard")
	private List<Inning> inning;
	
	@ManyToOne
	@JoinColumn(name="match_Id")
	private Match match;

	public ScoreBoard(long id, List<Inning> inning, Match match) {
		super();
		this.id = id;
		this.inning = inning;
		this.match = match;
	}

	public ScoreBoard() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Inning> getInning() {
		return inning;
	}

	public void setInning(List<Inning> inning) {
		this.inning = inning;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
}
