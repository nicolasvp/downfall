package com.downfall.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.Album;

public interface IAlbumDao extends CrudRepository<Album, Long>{

}
