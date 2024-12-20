package com.sportseventapplication.service;

import java.util.List;

import com.sportseventapplication.entity.Feedback;

public interface IFeedbackService {
	public Feedback createFeedback(Feedback feedback);
	public List<Feedback> getAllFeedback();
	public Feedback getFeedback(Long id);
	public Feedback updateFeedback(Feedback feedback, Long id);
	public void deleteFeedback(Long id);

}
