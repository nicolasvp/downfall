package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
