package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.downfall.app.models.entity.Country;
import com.downfall.app.models.services.ICountryService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class CountryController {
	
	@Autowired
	private ICountryService countryService;
	
	@GetMapping("/countries")
	public List<Country> index(){
		return countryService.findAll();
	}
}
