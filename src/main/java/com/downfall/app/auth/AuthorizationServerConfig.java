package com.downfall.app.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	@Autowired
	private AdditionalTokenInfo additionalTokenInfo;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticathed()");
	}

	// Se registra el o los clientes que usarán la API y se les asigna los permisos que tendrá
	// Cada cliente tiene un nombre asociado y una clave
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory().withClient("angular-downfall")
		.secret(passwordEncoder.encode("123123"))
		.scopes("read", "write")
		.authorizedGrantTypes("password", "refresh_token")
		.accessTokenValiditySeconds(3600) // Tiempo de validez del token en segundos (1hr)
		.refreshTokenValiditySeconds(3600); // Renueva la validez del token  (1hr)
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(additionalTokenInfo, accessTokenConverter()));
		
		// Traduce los datos del token
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore())
		.accessTokenConverter(accessTokenConverter())
		.tokenEnhancer(tokenEnhancerChain);
	}

	// Guarda el token
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	// Crea el token
	@Bean()
	public JwtAccessTokenConverter accessTokenConverter() {
		
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		
		// Asigna clave secreta para generar la firma del token
		jwtAccessTokenConverter.setSigningKey(JwtConfig.PRIVATE_RSA_KEY);
		// Asigna clave secreta para verificar el token
		jwtAccessTokenConverter.setVerifierKey(JwtConfig.PUBLIC_RSA_KEY);
		return jwtAccessTokenConverter;
	}
	
}
