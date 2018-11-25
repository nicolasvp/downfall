package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.downfall.app.models.entity.User;
import com.downfall.app.models.services.IUserService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/users")
	public List<User> index(){
		return userService.findAll();
	}
}
