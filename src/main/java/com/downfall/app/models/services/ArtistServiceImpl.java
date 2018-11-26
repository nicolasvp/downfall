package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.IArtistDao;
import com.downfall.app.models.entity.Artist;

@Service
public class ArtistServiceImpl implements IArtistService{

	@Autowired
	private IArtistDao artistDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Artist> findAll() {
		return (List<Artist>) artistDao.findAll();
	}

	@Override
	public Artist save(Artist artist) {
		return artistDao.save(artist);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		artistDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Artist findOne(Long id) {
		return artistDao.findById(id).orElse(null);
	}
}
