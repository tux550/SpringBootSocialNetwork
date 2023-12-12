package com.tuxedo.friendship_service.controllers;

import com.tuxedo.friendship_service.model.dtos.UserCreateRequest;
import com.tuxedo.friendship_service.model.dtos.UserFriendshipRequest;
import com.tuxedo.friendship_service.model.dtos.UserFriendshipResponse;
import com.tuxedo.friendship_service.services.FriendshipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FriendshipController {
    private final FriendshipService friendshipService;

    @PostMapping("/api/v1/friendship/user")
    public void createUser(@RequestBody UserCreateRequest userCreateRequest) {
        friendshipService.createUser(userCreateRequest);
    }

    @PostMapping("/api/v1/friendship/user/{id}/friends")
    public void createFriendship(@PathVariable String id, @RequestBody UserFriendshipRequest userFriendshipRequest) {
        friendshipService.createFriendship(id, userFriendshipRequest.getFriendId());
    }

    @GetMapping("/api/v1/friendship/user/{id}/friends")
    public List<UserFriendshipResponse> getFriends(@PathVariable String id) {
        return friendshipService.getFriendships(id);
    }

    @DeleteMapping("/api/v1/friendship/user/{id}/friends/{friendId}")
    public void deleteFriendship(@PathVariable String id, @PathVariable String friendId) {
        friendshipService.deleteFriendship(id, friendId);
    }

    @GetMapping("/api/v1/friendship/user/{id}/friends/{friendId}")
    public UserFriendshipResponse getFriend(@PathVariable String id, @PathVariable String friendId) {
        return friendshipService.getFriendship(id, friendId);
    }

}
