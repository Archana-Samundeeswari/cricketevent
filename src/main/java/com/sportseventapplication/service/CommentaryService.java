package com.sportseventapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.Commentary;
import com.sportseventapplication.repository.CommentaryRepository;
@Service
public class CommentaryService implements ICommenaryService{
	@Autowired
	private CommentaryRepository commentaryRepository;

	@Override
	public Commentary createCommentary(Commentary commentary) {
		
		return commentaryRepository.save(commentary);
	}

	@Override
	public List<Commentary> getAllCommentary() {

		return commentaryRepository.findAll() ;
	}

	@Override
	public Commentary getCommentary(Long id) {
		
		return commentaryRepository.findById(id).get();
	}

	@Override
	public Commentary updateCommentary(Commentary commentary, Long id) {
		commentary.setId(id);
		return commentaryRepository.save(commentary);
	}

	@Override
	public void deleteCommentary(Long id) {
		commentaryRepository.deleteById(id);
	}
	
}
