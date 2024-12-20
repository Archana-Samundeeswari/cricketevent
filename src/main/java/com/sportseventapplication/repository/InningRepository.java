package com.sportseventapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventapplication.entity.Inning;

public interface InningRepository extends JpaRepository<Inning, Long>{

}
