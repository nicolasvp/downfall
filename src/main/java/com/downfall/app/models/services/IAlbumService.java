package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Album;

public interface IAlbumService {
	public List<Album> findAll();
	
	public Album save(Album album);
	
	public Album findOne(Long id);
	
	public void delete(Long id);
}
