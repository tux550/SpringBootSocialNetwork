package com.tuxedo.friendship_service.repositories;

import com.tuxedo.friendship_service.model.entities.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Long> {
    User findByUserId(String userId);
}

