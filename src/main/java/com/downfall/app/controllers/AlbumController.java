package com.downfall.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.downfall.app.models.entity.Artist;
import com.downfall.app.models.services.IAlbumService;

/*
 * Acá se manejan las rutas y se asocian a metodos
 * Se implementa crossorigin para CORS con Angular
 */

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AlbumController {

	/*
	 * Se debe inyectar el servicio para hacer uso de sus metodos
	 */
	@Autowired
	private IAlbumService albumService;
	
	@GetMapping("/albums")
	public List<Album> index(){
		return albumService.findAll();
	}
	
	@GetMapping("/albums/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Album album = null;
		Map<String, Object> response = new HashMap<>();

		// Validacion de spring para el acceso a datos(base de datos)
		try {
			album = albumService.findById(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}

		// Validación para album no encontrado
		if (album == null) {
			response.put("msg", "El Album con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Album>(album, HttpStatus.OK);
	}
	
	@PostMapping("/albums")
	public ResponseEntity<?> create(@RequestBody Album album) {
		
		Album new_album = null;
		Map<String, Object> response = new HashMap<>();

		try {
			new_album = albumService.save(new_album);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar guardar el nuevo album");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Album creado con éxito");
		response.put("album", new_album);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/album/{id}")
	public ResponseEntity<?> update(@RequestBody Album album, @PathVariable Long id) {
		
		Album albumDB = albumService.findById(id);
		Album albumUpdated = null;
		Map<String, Object> response = new HashMap<>();

		// Si no se encontró el género devuelve un error
		if (albumDB == null) {
			response.put("msg", "El album no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			albumDB.setName(album.getName());
			albumDB.setImage(album.getImage());

			albumUpdated = albumService.save(albumDB);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar actualizar el album en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Album actualizado con éxito");
		response.put("album", albumUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/albums/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			albumService.delete(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar eliminar el album en la base de datos, el album no existe");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Album eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
