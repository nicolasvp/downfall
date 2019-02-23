package com.downfall.app.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.downfall.app.models.dao.IUserCustomDao;
import com.downfall.app.models.entity.UserCustom;

// Implementa la interfaz UserDetailsService (por esto no utiliza una interfaz user) 
@Service
public class UserCustomService implements UserDetailsService, IUserCustomService{

	@Autowired
	private IUserCustomDao userDao;
	
	private Logger logger = LoggerFactory.getLogger(UserCustomService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserCustom user = userDao.findByUsername(username);
		
		// Valida si existe el usuario, si no existe entonces retorna una excepcion
		if(user == null) {
			logger.error("El usuario '" + username + "' no existe");
			throw new UsernameNotFoundException("El usuario '" + username + "' no existe");
		}
		
		// Convierte el list de Roles a un list de SimpleGrantedAuthority, convirtiendolo primero a un stream y luego con map convierte a SimpleGrantedAuthority, muestra en consola el nombre del rol del usuario
		// stream -> map -> collect
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		// Retorna user de spring security
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	// Consulta personalizada
	@Override
	@Transactional(readOnly=true)
	public UserCustom findByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
