package com.downfall.app.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.Genre;

public interface IGenreDao extends CrudRepository<Genre, Long>{

}
