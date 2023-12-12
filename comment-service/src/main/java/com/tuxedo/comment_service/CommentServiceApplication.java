package com.tuxedo.comment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing
public class CommentServiceApplication {
	// TODO: Change to offset date
	// https://bootify.io/mongodb/created-and-last-modified-date-in-spring-data-mongodb.html
	public static void main(String[] args) {
		SpringApplication.run(CommentServiceApplication.class, args);
	}

}
