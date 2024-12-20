package com.sportseventapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tblInning")
@Data
public class Inning {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int Score;
	private double overs;
	private int wickets;

	@ManyToOne
	@JoinColumn(name="scoreBoard_Id")
	private ScoreBoard scoreBoard;

	public Inning(long id, int score, double overs, int wickets, ScoreBoard scoreBoard) {
		super();
		this.id = id;
		this.Score = score;
		this.overs = overs;
		this.wickets = wickets;
		this.scoreBoard = scoreBoard;
	}

	public Inning() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public double getOvers() {
		return overs;
	}

	public void setOvers(double overs) {
		this.overs = overs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

	public void setScoreBoard(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
	}
	
	
	
}
