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

/*
 * Acá se manejan las rutas y se asocian a metodos
 * Se implementa crossorigin para CORS con Angular
 */

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class GenreController {

	/*
	 * Se debe inyectar el servicio para hacer uso de sus metodos
	 */
	@Autowired
	private IGenreService genreService;
	
	@GetMapping("/genres")
	public List<Genre> index(){
		return genreService.findAll();
	}
	
	@GetMapping("/genres/{id}")
	public Genre show(@PathVariable Long id) {
		return genreService.findById(id);
	}
	
	@PostMapping("/genres")
	// Http status por defecto está en 200(ok), created es 201
	@ResponseStatus(HttpStatus.CREATED)
	public Genre create(@RequestBody Genre genre) {
		return genreService.save(genre);
	}
	
	@PutMapping("/genres/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Genre update(@RequestBody Genre genre, @PathVariable Long id) {
		Genre genreDB = genreService.findById(id);
		
		genreDB.setName(genre.getName());
		genreDB.setDescription(genre.getDescription());
		genreDB.setImage(genre.getImage());
		
		return genreService.save(genreDB);
	}
	
	@DeleteMapping("/genres/{id}")
	// HttpStatus response 401
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		genreService.delete(id);
	}
}
