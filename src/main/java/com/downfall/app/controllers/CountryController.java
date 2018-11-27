package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping("/countries/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Country show(@PathVariable Long id) {
		return countryService.findOne(id);
	}
	
	@PostMapping("/countries")
	@ResponseStatus(HttpStatus.CREATED)
	public Country store(@RequestBody Country country) {
		return countryService.save(country);
	}
	
	@PutMapping("/countries/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Country update(@RequestBody Country country, @PathVariable Long id) {
		Country countryUpdated = countryService.findOne(id);
		
		countryUpdated.setName(country.getName());
		countryUpdated.setArtists(country.getArtists());
		
		return countryService.save(countryUpdated);
	}
	
	@DeleteMapping("/countries/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		countryService.delete(id);
	}
}
