package com.sportseventapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Long>{

}
