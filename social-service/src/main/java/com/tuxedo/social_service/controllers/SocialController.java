package com.tuxedo.social_service.controllers;

import com.tuxedo.social_service.model.dtos.UserCreateRequest;
import com.tuxedo.social_service.model.dtos.UserFollowResponse;
import com.tuxedo.social_service.services.SocialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/social")
public class SocialController {
    private final SocialService socialService;

    @PostMapping("/user")
    public void createUser(@RequestBody UserCreateRequest userCreateRequest) {
        socialService.createUser(userCreateRequest);
    }

    @PostMapping("/user/{id}/follows/{targetId}")
    public void createFollow(@PathVariable UUID id, @PathVariable UUID targetId) {
        socialService.createFollow(id, targetId);
    }

    @GetMapping("/user/{id}/follows")
    public List<UserFollowResponse> getFollows(@PathVariable UUID id) {
        return socialService.getFollows(id);
    }

    @GetMapping("/user/{id}/followers")
    public List<UserFollowResponse> getFollowers(@PathVariable UUID id) {
        return socialService.getFollowers(id);
    }

    @PutMapping("/user/{id}/follows/{targetId}")
    public void acceptFollow(@PathVariable UUID id, @PathVariable UUID targetId) {
        socialService.acceptFollow(id, targetId);
    }

    @DeleteMapping("/user/{id}/follows/{targetId}")
    public void deleteFriendship(@PathVariable UUID id, @PathVariable UUID targetId) {
        socialService.deleteFollow(id, targetId);
    }

    @GetMapping("/user/{id}/follows/{targetId}")
    public UserFollowResponse getFollow(@PathVariable UUID id, @PathVariable UUID targetId) {
        return socialService.getFollow(id, targetId);
    }

}
