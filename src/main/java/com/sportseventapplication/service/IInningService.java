package com.sportseventapplication.service;

import java.util.List;

import com.sportseventapplication.entity.Inning;

public interface IInningService {
	public Inning createInning(Inning inning);
	public List<Inning> getAllInning();
	public Inning getInning(Long id);
	public Inning updateInning(Inning inning, Long id);
	public void deleteInning(Long id);
	
}
