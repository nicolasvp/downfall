package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.ITrackDao;
import com.downfall.app.models.entity.Track;

@Service
public class TrackServiceImpl implements ITrackService{

	/*
	 * Acá se implementan los metodos declarados en la interfaz de IGenreService
	 */
	
	// Se utiliza el objeto de Dao para utilizar los metodos del crudRepository
	@Autowired
	private ITrackDao trackDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Track> findAll() {
		return (List<Track>) trackDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Track findById(Long id) {
		return trackDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Track save(Track track) {
		return trackDao.save(track);
	}

	@Override
	@Transactional()
	public void delete(Long id) {
		trackDao.deleteById(id);
	}
}
