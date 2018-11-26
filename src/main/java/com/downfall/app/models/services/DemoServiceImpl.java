package com.downfall.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.IDemoDao;
import com.downfall.app.models.entity.Demo;

@Service
public class DemoServiceImpl implements IDemoService{

	@Autowired
	private IDemoDao demoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Demo> findAll() {
		return (List<Demo>) demoDao.findAll();
	}

	@Override
	public Demo save(Demo demo) {
		return demoDao.save(demo);
	}

	@Override
	@Transactional(readOnly=true)
	public Demo findOne(Long id) {
		return demoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		demoDao.deleteById(id);
	}

}
