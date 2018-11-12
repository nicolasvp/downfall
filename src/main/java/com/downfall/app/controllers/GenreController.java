package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.downfall.app.models.entity.Genre;
import com.downfall.app.models.services.IGenreService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class GenreController {

	@Autowired
	private IGenreService genreService;
	
	@GetMapping("/genres")
	public List<Genre> index(){
		return genreService.findAll();
	}
}
