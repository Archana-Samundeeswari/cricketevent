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
@Table(name = "tblFeedBack")
@Data

public class Feedback {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private int rating;
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="match_Id")
	private Match match;

	public Feedback(long id, int rating, String comment, User user, Match match) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.user = user;
		this.match = match;
	}

	public Feedback() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
}
