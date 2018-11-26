package com.downfall.app.models.services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.downfall.app.models.dao.IAlbumDao;
import com.downfall.app.models.entity.Album;

@Service
public class AlbumServiceImpl implements IAlbumService{

	@Autowired
	private IAlbumDao albumDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Album> findAll() {
		return (List<Album>) albumDao.findAll();
	}

	@Override
	public Album save(Album album) {
		return albumDao.save(album);
	}

	@Override
	@Transactional(readOnly=true)
	public Album findOne(Long id) {
		return albumDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		albumDao.deleteById(id);
	}

}
