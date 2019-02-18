package com.downfall.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

import com.downfall.app.models.entity.Album;
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
	
	@GetMapping("/tracks/page/{page_number}")
	public Page<Track> index(@PathVariable Integer page_number){
		Pageable pageable = PageRequest.of(page_number, 4);
		return trackService.findAll(pageable);
	}
	
	@GetMapping("/tracks/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Track track = null;
		Map<String, Object> response = new HashMap<>();

		// Validacion de spring para el acceso a datos(base de datos)
		try {
			track = trackService.findById(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}

		// Validación para track no encontrado
		if (track == null) {
			response.put("msg", "El Track con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Track>(track, HttpStatus.OK);
	}
	
	@PostMapping("/tracks")
	public ResponseEntity<?> create(@Valid @RequestBody Track track, BindingResult result) {
		
		Track new_track = null;
		Map<String, Object> response = new HashMap<>();

		// Si no pasa la validación entonces lista los errores y los retorna
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			new_track = trackService.save(track);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar guardar la nueva canción");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Canción creada con éxito");
		response.put("track", new_track);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/tracks/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Track track, BindingResult result, @PathVariable Long id) {
		
		Track trackDB = trackService.findById(id);
		Track trackUpdated = null;
		Map<String, Object> response = new HashMap<>();

		// Si no pasa la validación entonces lista los errores y los retorna
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		// Si no se encontró el género devuelve un error
		if (trackDB == null) {
			response.put("msg", "La canción no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			trackDB.setName(track.getName());
			trackDB.setTrackNumber(track.getTrackNumber());
			trackDB.setDuration(track.getDuration());
			trackDB.setAlbum(track.getAlbum());

			trackUpdated = trackService.save(trackDB);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar actualizar la canción en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Canción actualizada con éxito");
		response.put("track", trackUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/tracks/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();

		try {
			trackService.delete(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar eliminar la canción en la base de datos, la canción no existe");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Canción eliminada con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
