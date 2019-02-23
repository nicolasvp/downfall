package com.downfall.app.models.services;

import com.downfall.app.models.entity.UserCustom;

public interface IUserCustomService {

	public UserCustom findByUsername(String username);
}
