package com.sportseventapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.Fan;
import com.sportseventapplication.repository.FanRepository;
@Service
public class FanService implements IFanService{
	@Autowired
	private FanRepository fanRepository;
	@Override
	public Fan createFan(Fan fan) {
		
		return fanRepository.save(fan);
	}

	@Override
	public List<Fan> getAllFan() {
		
		return fanRepository.findAll();
	}

	@Override
	public Fan getFan(Long id) {
		
		return fanRepository.findById(id).get();
	}

	@Override
	public Fan updateFan(Fan fan, Long id) {
		fan.setId(id);
		return fanRepository.save(fan);
	}

	@Override
	public void deleteFan(Long id) {
		fanRepository.deleteById(id);
		
	}

}
