package br.com.rafael.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.rafael.projeto.dto.AcessDTO;
import br.com.rafael.projeto.dto.AuthenticationDTO;
import br.com.rafael.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;

	public AcessDTO login(AuthenticationDTO authDto) {
	
		try {
		UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(userAuth);
		
        UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();
		
		String token = jwtUtils.generateTokenFromUserDatalsImpl(userAuthenticate);
		
		AcessDTO accessDto = new AcessDTO(token);
		
		return accessDto;
		
		}catch(BadCredentialsException e) {
			
		}
		return new AcessDTO("Acesso negado");
	}
	
}
