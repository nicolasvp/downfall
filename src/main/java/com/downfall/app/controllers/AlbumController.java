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

import com.downfall.app.models.entity.Album;
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
	public Album show(@PathVariable Long id) {
		return albumService.findById(id);
	}
	
	@PostMapping("/albums")
	// Http status por defecto está en 200(ok), created es 201
	@ResponseStatus(HttpStatus.CREATED)
	public Album create(@RequestBody Album album) {
		return albumService.save(album);
	}
	
	@PutMapping("/album/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Album update(@RequestBody Album album, @PathVariable Long id) {
		Album albumDB = albumService.findById(id);
		
		albumDB.setName(album.getName());
		albumDB.setImage(album.getImage());
		
		return albumService.save(albumDB);
	}
	
	@DeleteMapping("/albums/{id}")
	// HttpStatus response 401
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		albumService.delete(id);
	}
}
