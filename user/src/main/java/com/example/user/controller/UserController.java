package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.user.dto.UserDto;
import com.example.user.service.UserService;

import io.swagger.annotations.ApiOperation;


public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@ApiOperation(value="add user")
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
		return userservice.addUser(userDto);
	}

}
