package com.sportseventapplication.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tblTournament")
@Data
public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@OneToMany(mappedBy = "tournament")	
	private List<Match> Match;
	@OneToMany
	private List<Team> teams;
	
	
	
	
	/*
	 * @PrePersist public void createdDate() { this.startDate=LocalDate.now(); }
	 */


	public Tournament() {
		super();
	}


	public Tournament(long id, String name, LocalDate startDate, LocalDate endDate,
			List<com.sportseventapplication.entity.Match> match) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.Match = match;
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


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public List<Match> getMatch() {
		return Match;
	}


	public void setMatch(List<Match> match) {
		Match = match;
	}
}
