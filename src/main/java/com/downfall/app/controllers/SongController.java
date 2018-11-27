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

import com.downfall.app.models.entity.Song;
import com.downfall.app.models.services.ISongService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class SongController {

	@Autowired
	private ISongService songService;
	
	@GetMapping("/songs")
	public List<Song> index(){
		return songService.findAll();
	}
	
	@GetMapping("/songs/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Song show(@PathVariable Long id) {
		return songService.findOne(id);
	}
	
	@PostMapping("/songs")
	@ResponseStatus(HttpStatus.CREATED)
	public Song store(@RequestBody Song song) {
		return songService.save(song);
	}
	
	@PutMapping("/songs/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Song update(@RequestBody Song song, @PathVariable Long id) {
		Song songUpdated = songService.findOne(id);
		
		songUpdated.setName(song.getName());
		songUpdated.setAlbum(song.getAlbum());
		songUpdated.setCollaboration(song.getCollaboration());
		
		return songService.save(songUpdated);
	}
	
	@DeleteMapping("/songs/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		songService.delete(id);
	}
}
