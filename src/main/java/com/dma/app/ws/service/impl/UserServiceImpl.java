package com.dma.app.ws.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dma.app.ws.UserRepository;
import com.dma.app.ws.io.entity.UserEntity;
import com.dma.app.ws.service.UserService;
import com.dma.app.ws.shared.Utils;
import com.dma.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

}
