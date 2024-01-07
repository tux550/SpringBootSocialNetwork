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
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreateResponse createUser(@RequestBody UserCreateRequest user) {
        return userService.createUser(user);
    }

    @GetMapping("/api/v1/users")
    public List<UserGetResponse> getUser(@RequestBody UserGetRequestByIds request) {
        return userService.getUsersByIds(request);
    }

    @GetMapping("/api/v1/users/{id}")
    public UserGetResponse getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }
}
