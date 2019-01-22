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

import com.downfall.app.models.entity.Artist;
import com.downfall.app.models.services.IArtistService;

/*
 * Acá se manejan las rutas y se asocian a metodos
 * Se implementa crossorigin para CORS con Angular
 */

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ArtistController {

	/*
	 * Se debe inyectar el servicio para hacer uso de sus metodos
	 */
	@Autowired
	private IArtistService artistService;
	
	@GetMapping("/artists")
	public List<Artist> index(){
		return artistService.findAll();
	}
	
	@GetMapping("/artists/{id}")
	public Artist show(@PathVariable Long id) {
		return artistService.findById(id);
	}
	
	@PostMapping("/artists")
	// Http status por defecto está en 200(ok), created es 201
	@ResponseStatus(HttpStatus.CREATED)
	public Artist create(@RequestBody Artist artist) {
		return artistService.save(artist);
	}
	
	@PutMapping("/artists/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Artist update(@RequestBody Artist artist, @PathVariable Long id) {
		Artist artistDB = artistService.findById(id);
		
		artistDB.setName(artist.getName());
		artistDB.setImage(artist.getImage());
		
		return artistService.save(artistDB);
	}
	
	@DeleteMapping("/artists/{id}")
	// HttpStatus response 401
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		artistService.delete(id);
	}
}
