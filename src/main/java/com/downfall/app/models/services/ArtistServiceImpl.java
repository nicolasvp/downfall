package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.IArtistDao;
import com.downfall.app.models.entity.Artist;

@Service
public class ArtistServiceImpl implements IArtistService{

	/*
	 * Acá se implementan los metodos declarados en la interfaz de IGenreService
	 */
	
	// Se utiliza el objeto de Dao para utilizar los metodos del crudRepository
	@Autowired
	private IArtistDao artistDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Artist> findAll() {
		return (List<Artist>) artistDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Artist findById(Long id) {
		return artistDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Artist save(Artist artist) {
		return artistDao.save(artist);
	}

	@Override
	@Transactional()
	public void delete(Long id) {
		artistDao.deleteById(id);
	}

}
