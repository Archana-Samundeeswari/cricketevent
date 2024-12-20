package com.sportseventapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.ScoreBoard;
import com.sportseventapplication.repository.ScoreBoardRepository;

@Service
public class ScoreBoardService implements IScoreBoardService{
	@Autowired
	private ScoreBoardRepository scoreBoardRepository;

	@Override
	public ScoreBoard createScoreBoard(ScoreBoard scoreBoard) {
		
		return scoreBoardRepository.save(scoreBoard);
	}

	@Override
	public List<ScoreBoard> getAllScoreBoard() {
		
		return scoreBoardRepository.findAll();
	}

	@Override
	public ScoreBoard getScoreBoard(Long id) {
		
		return scoreBoardRepository.findById(id).get();
	}

	@Override
	public ScoreBoard updateScoreBoard(ScoreBoard scoreBoard, Long id) {
		scoreBoard.setId(id);
		return scoreBoardRepository.save(scoreBoard);
	}

	@Override
	public void deleteScoreBoard(Long id) {
		scoreBoardRepository.deleteById(id);
		
	}
	
}
