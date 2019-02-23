package com.downfall.app.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.downfall.app.models.entity.UserCustom;
import com.downfall.app.models.services.IUserCustomService;

/*
 * Clase para adicionar más información al token(hacerlo más seguro)
 */
@Component
public class AdditionalTokenInfo implements TokenEnhancer{

	@Autowired
	private IUserCustomService userService;
	
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UserCustom user = userService.findByUsername(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		
		// Agregar informacion al map info, la info puede ser extraida desde el service o el authentication
		info.put("additional_info", "Your name: ".concat(authentication.getName()));
		info.put("additional_info", "Your email: ".concat(user.getEmail()));
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
