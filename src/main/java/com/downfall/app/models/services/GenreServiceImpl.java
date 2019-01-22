package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.IGenreDao;
import com.downfall.app.models.entity.Genre;

@Service
public class GenreServiceImpl implements IGenreService{

	/*
	 * Acá se implementan los metodos declarados en la interfaz de IGenreService
	 */
	
	// Se utiliza el objeto de Dao para utilizar los metodos del crudRepository
	@Autowired
	private IGenreDao genreDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Genre> findAll() {
		return (List<Genre>) genreDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Genre findById(Long id) {
		return genreDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Genre save(Genre genre) {
		return genreDao.save(genre);
	}

	@Override
	@Transactional()
	public void delete(Long id) {
		genreDao.deleteById(id);
	}

}
