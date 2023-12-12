package com.tuxedo.friendship_service.controllers;

import com.tuxedo.friendship_service.services.FriendshipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FriendshipController {
    private final FriendshipService friendshipService;

    @PutMapping("/api/v1/friendship/user")
    public void createUser() {
        // CREATE USER ENTRY
    }

    @PutMapping("/api/v1/friendship/user/{id}/friends")
    public void createFriendship() {
        // CREATE FRIENDSHIP
    }

    @DeleteMapping("/api/v1/friendship/user/{id}/friends")
    public void deleteFriendship() {
        // DELETE FRIENDSHIP
    }

    @GetMapping("/api/v1/friendship/user/{id}/friends")
    public void getFriends() {
        // GET FRIEND LIST
    }

    @GetMapping("/api/v1/friendship/user/{id}/friends/{friendId}")
    public void getFriend() {
        // GET FRIEND
    }

}
