package com.sportseventapplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tblCommentary")
@Data
@Getter
@Setter
public class Commentary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime timeStamp;
	private String text;
	
	@ManyToOne
	@JoinColumn(name="match_Id")
	private Match commentary;

	public Commentary(long id, LocalDateTime timeStamp, String text, Match commentary) {
		super();
		this.id = id;
		this.timeStamp = timeStamp;
		this.text = text;
		this.commentary = commentary;
	}

	public Commentary() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Match getCommentary() {
		return commentary;
	}

	public void setCommentary(Match commentary) {
		this.commentary = commentary;
	}
	
}
