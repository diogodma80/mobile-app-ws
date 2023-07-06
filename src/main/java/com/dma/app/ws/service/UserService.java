package com.dma.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dma.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	
	UserDto createUser(UserDto user);

}
