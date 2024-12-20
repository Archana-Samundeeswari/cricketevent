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
@Table(name="tblFan")
@Data
public class Fan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long favoriteTeamId;
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private User user;

	public Fan(long id, long favoriteTeamId, User user) {
		
		this.id = id;
		this.favoriteTeamId = favoriteTeamId;
		this.user = user;
	}

	public Fan() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFavoriteTeamId() {
		return favoriteTeamId;
	}

	public void setFavoriteTeamId(long favoriteTeamId) {
		this.favoriteTeamId = favoriteTeamId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
