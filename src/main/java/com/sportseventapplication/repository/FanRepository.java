package com.sportseventapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.Fan;

public interface FanRepository extends JpaRepository<Fan, Long>{

}
