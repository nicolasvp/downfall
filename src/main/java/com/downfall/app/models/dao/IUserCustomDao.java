package com.downfall.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.UserCustom;

public interface IUserCustomDao extends CrudRepository<UserCustom, Long>{

	/*
	 * Las consultas se pueden hacer con @Query o solo con findBy... donde cada palabra se traduce a un selector SQL
	 * find = select
	 * By = where
	 */
	// Consulta personalizada
	@Query("select u from UserCustom u where u.username=?1")
	public UserCustom findByUsername(String username);
	
	@Query("select u from UserCustom u where u.email=?1")
	public UserCustom findByEmail(String email);
}
