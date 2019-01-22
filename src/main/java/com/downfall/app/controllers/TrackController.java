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

import com.downfall.app.models.entity.Track;
import com.downfall.app.models.services.ITrackService;

/*
 * Acá se manejan las rutas y se asocian a metodos
 * Se implementa crossorigin para CORS con Angular
 */

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class TrackController {

	/*
	 * Se debe inyectar el servicio para hacer uso de sus metodos
	 */
	@Autowired
	private ITrackService trackService;
	
	@GetMapping("/tracks")
	public List<Track> index(){
		return trackService.findAll();
	}
	
	@GetMapping("/tracks/{id}")
	public Track show(@PathVariable Long id) {
		return trackService.findById(id);
	}
	
	@PostMapping("/tracks")
	// Http status por defecto está en 200(ok), created es 201
	@ResponseStatus(HttpStatus.CREATED)
	public Track create(@RequestBody Track track) {
		return trackService.save(track);
	}
	
	@PutMapping("/tracks/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Track update(@RequestBody Track track, @PathVariable Long id) {
		Track trackDB = trackService.findById(id);
		
		trackDB.setName(track.getName());
		trackDB.setTrackNumber(track.getTrackNumber());
		trackDB.setDuration(track.getDuration());
		
		return trackService.save(trackDB);
	}
	
	@DeleteMapping("/tracks/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		trackService.delete(id);
	}
}
