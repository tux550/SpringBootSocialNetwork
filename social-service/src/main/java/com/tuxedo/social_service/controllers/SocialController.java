package com.tuxedo.social_service.controllers;

import com.tuxedo.social_service.model.dtos.UserCreateRequest;
import com.tuxedo.social_service.model.dtos.UserFollowRequest;
import com.tuxedo.social_service.model.dtos.UserFollowResponse;
import com.tuxedo.social_service.services.SocialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SocialController {
    private final SocialService socialService;

    @PostMapping("/api/v1/social/user")
    public void createUser(@RequestBody UserCreateRequest userCreateRequest) {
        socialService.createUser(userCreateRequest);
    }

    @PostMapping("/api/v1/social/user/{id}/follows")
    public void createFollow(@PathVariable UUID id, @RequestBody UserFollowRequest userFollowRequest) {
        socialService.createFollow(id, userFollowRequest.getTargetId());
    }

    @GetMapping("/api/v1/social/user/{id}/follows")
    public List<UserFollowResponse> getFollows(@PathVariable UUID id) {
        return socialService.getFollows(id);
    }

    @GetMapping("/api/v1/social/user/{id}/followers")
    public List<UserFollowResponse> getFollowers(@PathVariable UUID id) {
        return socialService.getFollowers(id);
    }

    @PutMapping("/api/v1/social/user/{id}/follows/{targetId}")
    public void acceptFollow(@PathVariable UUID id, @PathVariable UUID targetId) {
        socialService.acceptFollow(id, targetId);
    }

    @DeleteMapping("/api/v1/social/user/{id}/follows/{targetId}")
    public void deleteFriendship(@PathVariable UUID id, @PathVariable UUID targetId) {
        socialService.deleteFollow(id, targetId);
    }

    @GetMapping("/api/v1/social/user/{id}/follows/{targetId}")
    public UserFollowResponse getFollow(@PathVariable UUID id, @PathVariable UUID targetId) {
        return socialService.getFollow(id, targetId);
    }

}
