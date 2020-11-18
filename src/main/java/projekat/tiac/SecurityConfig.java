package projekat.tiac;


import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import projekat.tiac.service.impl.CustomUserDetailService;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	private final SecretKey secretKey;
	private final JwtConfig jwtConfig;
	
	public SecurityConfig(UserDetailsService userDetailsService, SecretKey secretKey, JwtConfig jwtConfig) {
		super();
		this.userDetailsService = userDetailsService;
		this.secretKey = secretKey;
		this.jwtConfig = jwtConfig;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.cors()
		.and()
		.addFilter(new JwtUsernameAndPasswordAuthFilter(authenticationManager(),jwtConfig,secretKey))
		.addFilterAfter(new JwtTokenVerifer(secretKey,jwtConfig), JwtUsernameAndPasswordAuthFilter.class)
		.authorizeRequests()
		.antMatchers("/api/korisnici/registration").permitAll()
		.anyRequest()
		.authenticated();
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthProvider());
	}


	@Bean
	public DaoAuthenticationProvider daoAuthProvider() {
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	
	
	

}
