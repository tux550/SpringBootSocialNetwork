package com.tuxedo.user_service.controllers;

import com.tuxedo.user_service.model.dtos.UserCreateResponse;
import com.tuxedo.user_service.model.dtos.UserGetRequestByIds;
import com.tuxedo.user_service.model.dtos.UserCreateRequest;
import com.tuxedo.user_service.model.dtos.UserGetResponse;
import com.tuxedo.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users-service/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreateResponse createUser(@RequestBody UserCreateRequest user) {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<UserGetResponse> getUser(@RequestBody UserGetRequestByIds request) {
        return userService.getUsersByIds(request);
    }

    @GetMapping("/users/{id}")
    public UserGetResponse getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }
}
