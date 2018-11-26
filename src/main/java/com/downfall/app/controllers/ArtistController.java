package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.downfall.app.models.entity.Artist;
import com.downfall.app.models.services.IArtistService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ArtistController {

	@Autowired
	private IArtistService artistService;
	
	@GetMapping("/artists")
	public List<Artist> index(){
		return artistService.findAll();
	}
	
	@GetMapping("/artists/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Artist show(@PathVariable Long id) {
		return artistService.findOne(id);
	}
	
	@PostMapping("/artists")
	@ResponseStatus(HttpStatus.CREATED)
	public Artist store(@RequestBody Artist artist) {
		return artistService.save(artist);
	}
}
