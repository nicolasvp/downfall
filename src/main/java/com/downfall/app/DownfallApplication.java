package com.downfall.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DownfallApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(DownfallApplication.class, args);
	}

	// Genera claves encriptadas en Bcrypt para utilizar en import.sql
	@Override
	public void run(String... args) throws Exception {
		
		String password = "123123";
		
		// Imprime 2 claves para la password
		for (int i = 0; i < 2; i ++) {
			String passwordBCrypt = passwordEncoder.encode(password);
			System.out.println(passwordBCrypt);
		}
		
	}
}
