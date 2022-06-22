package com.example.user.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.User;

public interface UserDao extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndPassward(String email, String passward);
	

}
