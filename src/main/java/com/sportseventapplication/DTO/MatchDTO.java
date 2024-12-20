package com.sportseventapplication.DTO;

public class MatchDTO {
	
	private Long id;
	private String name;
	private String team1;
	private String team2;
	private String tournament;
	public MatchDTO() {
		super();
	}
	public MatchDTO(Long id, String name, String team1, String team2, String tournament) {
		super();
		this.id = id;
		this.name = name;
		this.team1 = team1;
		this.team2 = team2;
		this.tournament = tournament;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getTournament() {
		return tournament;
	}
	public void setTournament(String tournament) {
		this.tournament = tournament;
	}
	
	

}
