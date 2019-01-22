package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Track;

public interface ITrackService {
	/*
	 * Aca se declaran los metodos que se utilizaran del crud repository
	 */
	public List<Track> findAll();
	
	public Track findById(Long id);
	
	// Save se utiliza para guardar al crear y actualizar
	public Track save(Track track);
	
	public void delete(Long id);
}
