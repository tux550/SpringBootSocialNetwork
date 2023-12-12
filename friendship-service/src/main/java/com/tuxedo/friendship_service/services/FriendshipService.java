package com.tuxedo.friendship_service.services;

import com.tuxedo.friendship_service.model.dtos.FriendshipQueryResult;
import com.tuxedo.friendship_service.model.dtos.UserCreateRequest;
import com.tuxedo.friendship_service.model.dtos.UserFriendshipResponse;
import com.tuxedo.friendship_service.model.entities.Friendship;
import com.tuxedo.friendship_service.repositories.FriendshipRepository;
import com.tuxedo.friendship_service.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
@Slf4j
public class FriendshipService {
    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    public void createUser(UserCreateRequest userCreateRequest) {
        var user = UserCreateRequest.toUser(userCreateRequest);
        userRepository.save(user);
    }

    public void createFriendship(String id, String friendId) {
        var user = userRepository.findByUserId(id);
        var friend = userRepository.findByUserId(friendId);
        user.addFriend(
                Friendship.builder()
                        .friend(friend)
                        .status("PENDING")
                        .build()
        );
        userRepository.save(user);
    }

    public void deleteFriendship(String id, String friendId) {
        friendshipRepository.deleteFriendshipByUsers(id, friendId);
    }

    public UserFriendshipResponse getFriendship(String id, String friendId) {
var user = userRepository.findByUserId(id);
        var friend = userRepository.findByUserId(friendId);
        Set<Friendship> friendships = user.getFriends();
        for (Friendship f : friend.getFriends()) {
            if (f.getFriend().getUserId().equals(id)) {
                friendships.add(f);
            }
        }
        return friendships.stream()
                .filter(friendship -> friendship.getFriend().getUserId().equals(friendId))
                .map(UserFriendshipResponse::fromFriendship)
                .findFirst()
                .orElseThrow();
    }

    public List<UserFriendshipResponse> getFriendships(String id) {

        var friendships = friendshipRepository.getFriendshipsByUser(id);
        // Map all friendships iterator to UserFriendshipResponse
        return friendships.stream()
                .map(UserFriendshipResponse::fromFriendshipQueryResult)
                .collect(Collectors.toList());
    }




}
