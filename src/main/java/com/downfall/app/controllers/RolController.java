package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.downfall.app.models.entity.Rol;
import com.downfall.app.models.services.IRolService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RolController {

	@Autowired
	private IRolService rolService;
	
	@GetMapping("/roles")
	public List<Rol> index(){
		return rolService.findAll();
	}
}
