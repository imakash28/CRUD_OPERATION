package com.example.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.user.dto.UpdateUserDto;
import com.example.user.dto.UserDto;
import com.example.user.model.Response;
import com.example.user.model.User;

public interface UserService {
	
	ResponseEntity<String> addUser(UserDto userDto);

	Response<List> getUserAllList();

	Optional<User> findById(Long id);

	Response<String> updateUser(UpdateUserDto updateUserDto);

	Response<String> updateStatus(Long id);

	Response<String> Signup(UserDto userDto);

	Response<String> Login(String email, String passward);

}
