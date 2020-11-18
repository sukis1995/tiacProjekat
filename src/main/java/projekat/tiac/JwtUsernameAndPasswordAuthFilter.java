package projekat.tiac;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUsernameAndPasswordAuthFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authMang;
	private JwtConfig jwtConfig;
	private SecretKey secretKey;
	
	public JwtUsernameAndPasswordAuthFilter(AuthenticationManager authMang,
												JwtConfig jwtConfig, SecretKey secretKey) {
		super();
		this.authMang = authMang;
		this.jwtConfig=jwtConfig;
		this.secretKey=secretKey;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			UsernameAndPasswordAuthRequest authRequest=new ObjectMapper().readValue(request.getInputStream(), UsernameAndPasswordAuthRequest.class);
		Authentication auth=new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
		System.out.println(auth.getAuthorities());
		return authMang.authenticate(auth);
		
		
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println(authResult.getAuthorities());
	String token=Jwts.builder()
				.setSubject(authResult.getName())
				.claim("authorities", authResult.getAuthorities())
				.setIssuedAt(new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
				.signWith(secretKey)
				.compact();
		response.addHeader(jwtConfig.getAuhthorizationHeader(),jwtConfig.getTokenPrefix() + token);
	}
	
	
	
	
		
}
