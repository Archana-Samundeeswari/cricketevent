package com.sportseventapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.Feedback;
import com.sportseventapplication.repository.FeedbackRepository;

@Service
public class FeedbackService implements IFeedbackService{
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Override
	public Feedback createFeedback(Feedback feedback) {
		
		return feedbackRepository.save(feedback);
	}

	@Override
	public List<Feedback> getAllFeedback() {
		
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback getFeedback(Long id) {
		
		return feedbackRepository.findById(id).get();
	}

	@Override
	public Feedback updateFeedback(Feedback feedback, Long id) {
		feedback.setId(id);
		return feedbackRepository.save(feedback);
	}

	@Override
	public void deleteFeedback(Long id) {
		feedbackRepository.deleteById(id);
		
	}
	
}
