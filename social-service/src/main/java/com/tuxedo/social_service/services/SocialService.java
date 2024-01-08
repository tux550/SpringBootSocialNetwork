package com.tuxedo.social_service.services;

import com.tuxedo.social_service.model.dtos.FollowQueryResult;
import com.tuxedo.social_service.model.dtos.UserCreateRequest;
import com.tuxedo.social_service.model.dtos.UserFollowResponse;
import com.tuxedo.social_service.model.entities.Follow;
import com.tuxedo.social_service.repositories.FollowRepository;
import com.tuxedo.social_service.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class SocialService {
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public void createUser(UserCreateRequest userCreateRequest) {
        var user = userCreateRequest.toUser();
        userRepository.save(user);
    }

    public void createFollow(UUID id, UUID targetId) {
        var user = userRepository.findByUserId(id);
        var followTarget = userRepository.findByUserId(targetId);
        // Check if already in follows
        var follows = user.getFollows();
        Optional<Follow> follow = follows.stream()
                .filter(f -> f.getFollowTarget().getUserId().equals(targetId))
                .findFirst();
        if (follow.isPresent()) {
            // Already Exists
            return;
        }
        // Create
        user.addFollow(
            Follow.builder()
                .followTarget(followTarget)
                .status(Follow.Status.PENDING)
                .build()
        );
        userRepository.save(user);
    }

    public void acceptFollow(UUID id, UUID targetId) {
        followRepository.updateFollowStatus(id, targetId, Follow.Status.ACCEPTED);
    }

    public void deleteFollow(UUID id, UUID targetId) {
        followRepository.deleteFollowByUserIdAndTargetId(id, targetId);
    }

    public UserFollowResponse getFollow(UUID id, UUID targetId) {
        var follow = followRepository.getFollow(id, targetId);
        return follow.stream()
                .findFirst()
                .map(FollowQueryResult::toUserFollowResponse)
                .orElseThrow();
    }

    public List<UserFollowResponse> getFollows(UUID id) {
        var friendships = followRepository.getFollowsByUserId(id);
        // Map all friendships iterator to UserFriendshipResponse
        return friendships.stream()
                .map(FollowQueryResult::toUserFollowResponse)
                .collect(Collectors.toList());
    }

    public List<UserFollowResponse> getFollowers(UUID id) {
        var friendships = followRepository.getFollowersByUserId(id);
        // Map all friendships iterator to UserFriendshipResponse
        return friendships.stream()
                .map(FollowQueryResult::toUserFollowResponse)
                .collect(Collectors.toList());
    }
}
