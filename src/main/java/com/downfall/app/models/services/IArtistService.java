package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Album;
import com.downfall.app.models.entity.Artist;

public interface IArtistService {
	public List<Artist> findAll();
	
	public Artist save(Artist artist);
	
	public Artist findOne(Long id);
	
	public void delete(Long id);
	
}
