package com.downfall.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping("/demos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Demo show(@PathVariable Long id) {
		return demoService.findOne(id);
	}
	
	@PostMapping("/demos")
	@ResponseStatus(HttpStatus.CREATED)
	public Demo store(@RequestBody Demo demo) {
		return demoService.save(demo);
	}
}
