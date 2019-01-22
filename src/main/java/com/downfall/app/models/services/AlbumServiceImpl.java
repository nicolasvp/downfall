package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.IAlbumDao;
import com.downfall.app.models.entity.Album;

@Service
public class AlbumServiceImpl implements IAlbumService{

	/*
	 * Acá se implementan los metodos declarados en la interfaz de IGenreService
	 */
	
	// Se utiliza el objeto de Dao para utilizar los metodos del crudRepository
	@Autowired
	private IAlbumDao albumDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Album> findAll() {
		return (List<Album>) albumDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Album findById(Long id) {
		return albumDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Album save(Album album) {
		return albumDao.save(album);
	}

	@Override
	@Transactional()
	public void delete(Long id) {
		albumDao.deleteById(id);
	}

}
