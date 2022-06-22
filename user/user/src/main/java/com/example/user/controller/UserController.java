package com.example.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.UpdateUserDto;
import com.example.user.dto.UserDto;
import com.example.user.model.Response;
import com.example.user.model.User;
import com.example.user.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="add user")
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
		return userService.addUser(userDto);
	}
	
	@ApiOperation(value="get all user List")
	@GetMapping("/get-all-user")
	public Response<List>getUserAllList(){
		return userService.getUserAllList();
	}

	@ApiOperation(value="API for getUser by Id")
	@GetMapping("/get-one-user")
	public Optional<User> findById(Long id){
		return userService.findById(id);
	}
	
	@ApiOperation(value="API for update User")
	@PostMapping("/update-user")
	public Response<String>updateUser(@RequestBody UpdateUserDto updateUserDto){
		return userService.updateUser(updateUserDto);
	}
	
	@ApiOperation(value="API for delete User")
	@DeleteMapping("/delete-user")
	public Response<String>updateStatus(@RequestParam Long id){
		return userService.updateStatus(id);       
	}
	
	@ApiOperation(value="API for Signup")
	@PostMapping("/signup-user")
	public Response<String> Signup(@RequestBody UserDto userDto){
		return userService.Signup(userDto);
	}
	
	@ApiOperation(value="API for Login")
	@PostMapping("/Login")
	public Response<String>Login(@RequestHeader String email,@RequestHeader String passward){
		return userService.Login(email,passward);
	}
}
