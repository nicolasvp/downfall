package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Demo;

public interface IDemoService {
	
	public List<Demo> findAll();
	
	public Demo save(Demo demo);
	
	public Demo findOne(Long id);
	
	public void delete(Long id);
}
