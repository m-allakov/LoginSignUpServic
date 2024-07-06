package com.user_manager_v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user_manager_v1.models.User;
import com.user_manager_v1.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public int registerNewUserServiceMethod(String fname, String lname, String email, String password) {
		return userRepository.registerNewUser(fname, lname, email, password);
	}

	// Get User Email Services Method:
	public List<String> checkUserEmail(String email){
		return userRepository.checkUserEmail(email);
	}
	//End of check Email Services Method.
	
	
	// Get User Password Services Method:
	public String checkUserPasswordByEmail(String email){
		return userRepository.checkUserPasswordByEmail(email);
	}
		//End of check Password Services Method.
		
	//
	public User getUserDetailByEmail(String email) {
		return userRepository.getUserDetailByEmail1(email);
	}
		
		
}
