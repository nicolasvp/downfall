package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.IGenreDao;
import com.downfall.app.models.entity.Genre;

@Service
public class GenreServiceImpl implements IGenreService {

	@Autowired
	private IGenreDao genreDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Genre> findAll() {
		return (List<Genre>) genreDao.findAll();
	}

}
