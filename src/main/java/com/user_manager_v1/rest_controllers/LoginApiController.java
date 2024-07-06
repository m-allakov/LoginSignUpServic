package com.user_manager_v1.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_manager_v1.models.Login;
import com.user_manager_v1.models.User;
import com.user_manager_v1.services.UserService;

@RestController
@RequestMapping("api/v1")
public class LoginApiController {
	
	@Autowired 
	UserService userService;

	@PostMapping("/user/login")
	public ResponseEntity authenticateUser(@RequestBody Login login) {
		try {
			// get User Email:
			List<String> userEmail = userService.checkUserEmail(login.getEmail());
			System.out.println("User email check completed.");

			// Check if email is empty:
			if (userEmail.isEmpty() || userEmail == null) {
				System.out.println("Email does not exist: " + login.getEmail());
				return new ResponseEntity("Email does not exist", HttpStatus.NOT_FOUND);
			}

			// Get Hashed User Password:
			String hashedPassword = userService.checkUserPasswordByEmail(login.getEmail());
			System.out.println("Hashed password retrieved.");

			// Validate User Password:
			if (!BCrypt.checkpw(login.getPassword(), hashedPassword)) {
				System.out.println("Incorrect username or password for email: " + login.getEmail());
				return new ResponseEntity("Incorrect username or password", HttpStatus.BAD_REQUEST);
			}

			// Set user Object
			User user = userService.getUserDetailByEmail(login.getEmail());
			System.out.println("User authenticated successfully.");

			return new ResponseEntity(user, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity("An internal error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
