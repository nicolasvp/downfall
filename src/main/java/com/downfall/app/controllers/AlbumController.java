package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
