package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.ISongDao;
import com.downfall.app.models.entity.Song;

@Service
public class SongServiceImpl implements ISongService{

	@Autowired
	private ISongDao songDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Song> findAll() {
		return (List<Song>) songDao.findAll();
	}

	@Override
	public Song save(Song song) {
		return songDao.save(song);
	}

	@Override
	@Transactional(readOnly=true)
	public Song findOne(Long id) {
		return songDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		songDao.deleteById(id);
	}

}
