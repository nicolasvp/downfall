package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
