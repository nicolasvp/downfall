package com.downfall.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{

}
