package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Artist;

public interface IArtistService {
	/*
	 * Aca se declaran los metodos que se utilizaran del crud repository
	 */
	public List<Artist> findAll();
	
	public Artist findById(Long id);
	
	// Save se utiliza para guardar al crear y actualizar
	public Artist save(Artist artist);
	
	public void delete(Long id);
}
