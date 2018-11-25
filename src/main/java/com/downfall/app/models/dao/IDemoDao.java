package com.downfall.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.Demo;

public interface IDemoDao extends CrudRepository<Demo, Long>{

}
