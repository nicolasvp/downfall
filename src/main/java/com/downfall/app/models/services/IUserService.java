package com.downfall.app.models.services;

import java.util.List;

import com.downfall.app.models.entity.User;

public interface IUserService {
	public List<User> findAll();
	
	public void save(User user);
	
	public User findOne(Long id);
	
	public void delete(Long id);
}
