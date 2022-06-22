package com.example.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.user.dao.UserDao;
import com.example.user.dto.UpdateUserDto;
import com.example.user.dto.UserDto;
import com.example.user.enums.UserStatus;
import com.example.user.model.Response;
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
	user.setUserStatus(UserStatus.ACTIVE);
	userDao.save(user);
		return new ResponseEntity<>("Entered",HttpStatus.OK);
	}
	
	

	@Override
	public Response<List> getUserAllList() {
		List<User>allUserList=userDao.findAll();
		if(!allUserList.isEmpty())
		{
			return new Response<List>(200,"All User List Get Successfully",allUserList);
		}
		else
		{
			return new Response<>(404,"User List is Not Found");
		}
	}
	
	

	@Override
	public Optional<User> findById(Long id) {
		return userDao.findById(id);
	}
	
	

	@Override
	public Response<String> updateUser(UpdateUserDto updateUserDto) {
		Optional<User>getUserDetails=userDao.findById(updateUserDto.getId());
		if(getUserDetails.isPresent()) {
			getUserDetails.get().setName(updateUserDto.getName());
			getUserDetails.get().setEmail(updateUserDto.getEmail());
			getUserDetails.get().setPhone(updateUserDto.getPhone());
			getUserDetails.get().setPassward(updateUserDto.getPassward());
			getUserDetails.get().setAddress(updateUserDto.getAddress());
			getUserDetails.get().setUserStatus(UserStatus.UPDATE);
			
			userDao.save(getUserDetails.get());
			return new Response<>(200, "User Data Updated Successfully");
		}
		else {
			return new Response<>(205, "User Data Not Found");
		}
		
		}



	@Override
	public Response<String> updateStatus(Long id) {
		Optional<User>updateStatusDelete=userDao.findById(id);
		if(updateStatusDelete.isPresent()) {
			updateStatusDelete.get().setUserStatus(UserStatus.DELETED);
			userDao.save(updateStatusDelete.get());
			return new Response<>(200,"User Details Deleted Successfully");
		}
		else {
			return new Response<>(205, "User Details Not Found");
		}
	}



	@Override
	public Response<String> Signup(UserDto userDto) {
		Optional<User>isEmailExist=userDao.findByEmail(userDto.getEmail());
		User user=new User();
		if(!isEmailExist.isPresent()) {
			user.setEmail(userDto.getEmail());
			user.setAddress(userDto.getAddress());
			user.setPhone(userDto.getPhone());
			user.setPassward(userDto.getPassward());
			userDao.save(user);
			return new Response<>(200, "User-Signup-Successfully");
		}else
		{
			return new Response<>(205,"User-Email-Already-Exist");
		}
	}



	@Override
	public Response<String> Login(String email, String passward) {
		Optional<User>isDataPresent=userDao.findByEmailAndPassward(email,passward);
		if(isDataPresent.isPresent()) {
			isDataPresent.get().setEmail(email);
			isDataPresent.get().setPassward(passward);
			return new Response<>(200, "User-Login-Successfully");
		}else {
			return new Response<>(205, "User-Does-Not-Exist");
		}
	}
	
}

	
	
	
	
	
	

