package com.downfall.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.Artist;

public interface IArtistDao extends CrudRepository<Artist, Long>{

}
