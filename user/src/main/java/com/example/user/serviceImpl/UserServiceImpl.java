package com.example.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.user.dao.UserDao;
import com.example.user.dto.UserDto;
import com.example.user.model.User;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<String> addUser(UserDto userDto) {
	User user=new User();
	user.setName(userDto.getName());
	user.setAge(userDto.getAge());
	user.setCity(userDto.getCity());
	user.setEmail(userDto.getEmail());
	user.setGender(userDto.getGender());
	user.setAddress(userDto.getAddress());
	user.setPhone(userDto.getPhone());
	user.setPassward(userDto.getPassward());
	userDao.save(user);
		return new ResponseEntity<>("Eneterd",HttpStatus.OK);
	}
	
	
	
	
	
	
}
