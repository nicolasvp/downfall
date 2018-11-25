package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.downfall.app.models.entity.Demo;
import com.downfall.app.models.services.IDemoService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class DemoController {

	@Autowired
	private IDemoService demoService;
	
	@GetMapping("/demos")
	public List<Demo> index(){
		return demoService.findAll();
	}
}
