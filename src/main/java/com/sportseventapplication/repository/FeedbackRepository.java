package com.sportseventapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
