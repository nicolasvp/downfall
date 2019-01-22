package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Genre;

public interface IGenreService {
	/*
	 * Aca se declaran los metodos que se utilizaran del crud repository
	 */
	public List<Genre> findAll();
	
	public Genre findById(Long id);
	
	// Save se utiliza para guardar al crear y actualizar
	public Genre save(Genre genre);
	
	public void delete(Long id);
}
