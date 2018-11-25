package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Genre;

public interface IGenreService {
	public List<Genre> findAll();
	
	public void save(Genre genre);
	
	public Genre findOne(Long id);
	
	public void delete(Long id);
}
