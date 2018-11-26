package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Song;

public interface ISongService {
	public List<Song> findAll();
	
	public Song save(Song song);
	
	public Song findOne(Long id);
	
	public void delete(Long id);
}
