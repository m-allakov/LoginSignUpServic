-- DATABASE NAME:
CREATE DATABASE user_manager_v1;

USE user_manager_v1;


-- USER TABLE SRTRUCKTER:
CREATE TABLE users(
	user_id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	created_at TIMESTAMP,
	created_at TIMESTAMP,
	PRIMARY KEY(user_id));