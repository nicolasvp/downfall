package com.downfall.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long>{

}
