package com.downfall.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import com.downfall.app.models.entity.Artist;
import com.downfall.app.models.entity.Genre;
import com.downfall.app.models.services.IArtistService;

/*
 * Acá se manejan las rutas y se asocian a metodos
 * Se implementa crossorigin para CORS con Angular
 */

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ArtistController {

	/*
	 * Se debe inyectar el servicio para hacer uso de sus metodos
	 */
	@Autowired
	private IArtistService artistService;

	@GetMapping("/artists")
	public List<Artist> index() {
		return artistService.findAll();
	}

	@GetMapping("/artists/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Artist artist = null;
		Map<String, Object> response = new HashMap<>();

		// Validacion de spring para el acceso a datos(base de datos)
		try {
			artist = artistService.findById(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}

		// Validación para artista no encontrado
		if (artist == null) {
			response.put("msg", "El artista con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Artist>(artist, HttpStatus.OK);
	}

	@PostMapping("/artists")
	public ResponseEntity<?> create(@Valid @RequestBody Artist artist, BindingResult result) {

		Artist new_artist = null;
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
			new_artist = artistService.save(artist);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar guardar el nuevo artista");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Artista creado con éxito");
		response.put("artist", new_artist);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/artists/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Artist artist, BindingResult result, @PathVariable Long id) {

		Artist artistDB = artistService.findById(id);
		Artist artistUpdated = null;
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
		if (artistDB == null) {
			response.put("msg", "El artista no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			artistDB.setName(artist.getName());
			artistDB.setImage(artist.getImage());
			artistDB.setYoutubeLink(artist.getYoutubeLink());
			artistDB.setSpotifyLink(artist.getSpotifyLink());
			artistDB.setGenre(artist.getGenre());

			artistUpdated = artistService.save(artistDB);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar actualizar el artista en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Artista actualizado con éxito");
		response.put("artist", artistUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/artists/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			artistService.delete(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar eliminar el artista en la base de datos, el artista no existe");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("msg", "Artista eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
