package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Genre;

public interface IGenreService {
	public List<Genre> findAll();
}
