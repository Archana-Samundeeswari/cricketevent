package com.sportseventapplication.service;

import java.util.List;

import com.sportseventapplication.entity.ScoreBoard;

public interface IScoreBoardService {
	public ScoreBoard createScoreBoard(ScoreBoard scoreBoard);
	public List<ScoreBoard> getAllScoreBoard();
	public ScoreBoard getScoreBoard(Long id);
	public ScoreBoard updateScoreBoard(ScoreBoard scoreBoard, Long id);
	public void deleteScoreBoard(Long id);
}
