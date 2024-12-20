package com.sportseventapplication.service;

import java.util.List;

import com.sportseventapplication.entity.Commentary;

public interface ICommenaryService {
	public Commentary createCommentary(Commentary commentary);
	public List<Commentary> getAllCommentary();
	public Commentary getCommentary(Long id);
	public Commentary updateCommentary(Commentary commentary, Long id);
	public void deleteCommentary(Long id);
	
}
