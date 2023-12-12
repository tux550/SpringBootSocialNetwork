package com.tuxedo.postservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.OffsetDateTime;
import java.util.Optional;

@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing
public class PostServiceApplication {
	// TODO: Change to offset date
	// https://bootify.io/mongodb/created-and-last-modified-date-in-spring-data-mongodb.html
	public static void main(String[] args) {
		SpringApplication.run(PostServiceApplication.class, args);
	}

}
