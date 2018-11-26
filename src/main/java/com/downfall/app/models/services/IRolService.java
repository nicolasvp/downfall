package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.Rol;

public interface IRolService {
	public List<Rol> findAll();
	
	public Rol save(Rol rol);
	
	public Rol findOne(Long id);
	
	public void delete(Long id);
}
