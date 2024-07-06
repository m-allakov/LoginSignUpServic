package com.user_manager_v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.user_manager_v1.models.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query(value = "Select email FROM users Where email = :email", nativeQuery = true)
	List<String> checkUserEmail(@Param("email") String email);
		
	@Query(value = "SELECT password FROM users WHERE email = :email", nativeQuery = true)
	String checkUserPasswordByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
	User getUserDetailByEmail1(@Param("email") String email);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO USERS(first_name, last_name, email, password) VALUES(:first_name, :last_name, :email, :password) ", nativeQuery = true)
	int registerNewUser(@Param("first_name") String first_name,
			@Param("last_name") String last_name,
			@Param("email") String email,
			@Param("password") String password);
	

}
 