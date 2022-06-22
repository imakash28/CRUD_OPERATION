package com.example.user.service;

import org.springframework.http.ResponseEntity;

import com.example.user.dto.UserDto;

public interface UserService {
	
	ResponseEntity<String> addUser(UserDto userDto);

}
