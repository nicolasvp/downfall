package com.downfall.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.Song;

public interface ISongDao extends CrudRepository<Song, Long>{

}
