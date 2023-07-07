package com.dma.app.ws.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import com.dma.app.ws.service.UserService;

@EnableWebSecurity
public class WebSecurity {

	private final UserService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		// super();
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		// Configure AuthenticationManagerBuilder
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);

		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

		AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

		AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager);
        authenticationFilter.setFilterProcessesUrl("/users/login");
        
        /*
		http.cors().and().csrf().disable()
		.authorizeHttpRequests()
			.requestMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
		.anyRequest()
			.authenticated()
		.and()
			.authenticationManager(authenticationManager)
			.addFilter(new AuthenticationFilter(authenticationManager));

		return http.build();*/
        
        
        http
        .csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests((authz) -> authz
        .requestMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
        .anyRequest().authenticated())
        .authenticationManager(authenticationManager)
        .addFilter(authenticationFilter)
        // line 63 fails iwth AuthorizationFilter and is redundant if I change it to AuthenticationFilter
        // .addFilter(new AuthorizationFilter(authenticationManager))
        .sessionManagement((session) -> session
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
		
	}

}
