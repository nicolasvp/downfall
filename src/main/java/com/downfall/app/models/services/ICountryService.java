package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Country;

public interface ICountryService {
	
	public List<Country> findAll();
	
	public void save(Country country);
	
	public Country findOne(Long id);
	
	public void delete(Long id);
}
