package com.tuxedo.user_service.repositories;

import com.tuxedo.user_service.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
