package com.sportseventapplication.service;

import java.util.List;

import com.sportseventapplication.entity.Fan;

public interface IFanService {

	public Fan createFan(Fan fan);
	public List<Fan> getAllFan();
	public Fan getFan(Long id);
	public Fan updateFan(Fan fan, Long id);
	public void deleteFan(Long id);
}
