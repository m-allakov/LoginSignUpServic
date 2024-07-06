package com.user_manager_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.user_manager_v1")
public class UserManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagmentApplication.class, args);
	}

}
