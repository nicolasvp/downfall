package com.downfall.app.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
 * Configuracion para OAuth2
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	// Reglas para acceso, todo lo que sea público se DEBE dejar anotado acá, el resto puede ser indicado con Secure en los controladores
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/genres").permitAll() // genres tiene acceso publico, no necesita autenticacion (permitAll())
		/*.antMatchers(HttpMethod.GET, "/api/genres/{id}").hasAnyRole("ADMIN", "USER") // El rol se define sin el prefijo "ROLE_" ya que se concatena por debajo
		.antMatchers(HttpMethod.POST, "/api/genres").hasRole("ADMIN") // Solo ADMIN puede crear, actualizar y eliminar
		.antMatchers(HttpMethod.PUT, "/api/genres/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/genres/{id}").hasRole("ADMIN") */
		.anyRequest().authenticated() // Cualquier otra petición será solo para usuarios autenticados
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	// Configuracion para permisos mediante CORS
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
    // Filtro Cors para registrarlo dentro de los filtros que maneja spring
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
    	FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
    	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    	
    	return bean;
    }
}
