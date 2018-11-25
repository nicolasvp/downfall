package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Album;

public interface IAlbumService {
	public List<Album> findAll();
	
	public void save(Album client);
	
	public Album findOne(Long id);
	
	public void delete(Long id);
}
