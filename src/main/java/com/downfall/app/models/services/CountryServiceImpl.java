package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.ICountryDao;
import com.downfall.app.models.entity.Country;

@Service
public class CountryServiceImpl implements ICountryService {
	
	@Autowired
	private ICountryDao countryDao;

	@Override
	@Transactional(readOnly = true)
	public List<Country> findAll() {
		return (List<Country>) countryDao.findAll();
	}

	@Override
	public void save(Country country) {
		countryDao.save(country);
	}

	@Override
	@Transactional(readOnly=true)
	public Country findOne(Long id) {
		return countryDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		countryDao.deleteById(id);
	}
}
