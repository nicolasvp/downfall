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
	
	@GetMapping("/genres/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Genre show(@PathVariable Long id) {
		return genreService.findOne(id);
	}
	
	@PostMapping("/genres")
	@ResponseStatus(HttpStatus.CREATED)
	public Genre store(@RequestBody Genre genre) {
		return genreService.save(genre);
	}
	
	@PutMapping("/genres/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Genre update(@RequestBody Genre genre, @PathVariable Long id) {
		Genre genreUpdated = genreService.findOne(id);
		
		genreUpdated.setName(genre.getName());
		genreUpdated.setArtists(genre.getArtists());
		
		return genreService.save(genreUpdated);
	}
	
	@DeleteMapping("/genres/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		genreService.delete(id);
	}
}
