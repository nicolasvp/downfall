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

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class AlbumController {
	
	@Autowired
	private IAlbumService albumService;
	
	@GetMapping("/albums")
	public List<Album> index(){
		return albumService.findAll();
	}
	
	@GetMapping("/albums/{id}")
	@ResponseStatus(HttpStatus.OK) // codigo 200
	public Album show(@PathVariable Long id) {
		return albumService.findOne(id);
	}
	
	@PostMapping("/albums")
	@ResponseStatus(HttpStatus.CREATED) // codigo 201
	public Album store(@RequestBody Album album) {
		return albumService.save(album);
	}
	
	@PutMapping("/albums/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Album update(@RequestBody Album album, @PathVariable Long id) {
		Album albumUpdated = albumService.findOne(id);
		
		albumUpdated.setArtist(album.getArtist());
		albumUpdated.setName(album.getName());
		albumUpdated.setPhoto(album.getPhoto());
		albumUpdated.setSongs(album.getSongs());
		
		return albumService.save(albumUpdated);
	}
	
	@DeleteMapping("/albums/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		albumService.delete(id);
	}
}
