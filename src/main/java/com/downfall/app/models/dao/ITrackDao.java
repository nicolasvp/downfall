package com.downfall.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.Track;

public interface ITrackDao extends CrudRepository<Track, Long>{

}
