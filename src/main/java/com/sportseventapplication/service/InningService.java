package com.sportseventapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.Inning;
import com.sportseventapplication.repository.InningRepository;

@Service
public class InningService implements IInningService{
	@Autowired
	private InningRepository inningRepository;
	
	@Override
	public Inning createInning(Inning inning) {
		
		return inningRepository.save(inning);
	}

	@Override
	public List<Inning> getAllInning() {
		
		return inningRepository.findAll();
	}

	@Override
	public Inning getInning(Long id) {
		
		return inningRepository.findById(id).get();
	}

	@Override
	public Inning updateInning(Inning inning, Long id) {
		inning.setId(id);
		return inningRepository.save(inning);
	}

	@Override
	public void deleteInning(Long id) {
		inningRepository.deleteById(id);
	}
	
}
