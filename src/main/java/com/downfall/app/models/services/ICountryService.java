package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Country;

public interface ICountryService {
	
	public List<Country> findAll();
}
