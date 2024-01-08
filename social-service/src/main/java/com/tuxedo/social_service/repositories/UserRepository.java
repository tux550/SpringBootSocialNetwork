package com.tuxedo.social_service.repositories;

import com.tuxedo.social_service.model.entities.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface UserRepository extends Neo4jRepository<User, UUID> {
    User findByUserId(UUID userId);
}

