package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Album;

public interface IAlbumService {
	/*
	 * Aca se declaran los metodos que se utilizaran del crud repository
	 */
	public List<Album> findAll();
	
	public Album findById(Long id);
	
	// Save se utiliza para guardar al crear y actualizar
	public Album save(Album album);
	
	public void delete(Long id);
}
