package com.tuxedo.user_service.services;

import com.tuxedo.user_service.model.dtos.UserCreateResponse;
import com.tuxedo.user_service.model.dtos.UserRequestByIds;
import com.tuxedo.user_service.model.dtos.UserCreateRequest;
import com.tuxedo.user_service.model.dtos.UserResponse;
import com.tuxedo.user_service.model.entities.User;
import com.tuxedo.user_service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {
        var user = UserCreateRequest.toUser(userCreateRequest);
        userRepository.save(user);
        log.info("Adding user: {}", user);
        return UserCreateResponse.fromUser(user);
    }

    public UserResponse getUser(String id) {
        UUID user_uuid = UUID.fromString(id);
        var user = userRepository.findById(user_uuid).orElseThrow(
            () -> new RuntimeException("User not found")
        );
        log.info("Getting user: {}", user);
        return UserResponse.fromUser(user);
    }

    public List<UserResponse> getUsersByIds(UserRequestByIds request) {
        var users = userRepository.findAllById(request.getIds());
        log.info("Getting users: {}", users);
        return users.stream()
                .map(UserResponse::fromUser)
                .toList();
    }


}
