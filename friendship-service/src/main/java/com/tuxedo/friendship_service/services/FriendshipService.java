package com.tuxedo.friendship_service.services;

import com.tuxedo.friendship_service.model.dtos.UserCreateRequest;
import com.tuxedo.friendship_service.model.dtos.UserFriendshipResponse;
import com.tuxedo.friendship_service.model.entities.Friendship;
import com.tuxedo.friendship_service.repositories.FriendshipRepository;
import com.tuxedo.friendship_service.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


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
        var friendship = friendshipRepository.getFriendshipByUsers(id, friendId);
        return UserFriendshipResponse.fromFriendship(friendship);
    }

    public List<UserFriendshipResponse> getFriendships(String id) {
        var friendships = friendshipRepository.getFriendshipsByUsers(id);
        for (Friendship friendship : friendships) {
            log.info(friendship.toString());
        }
        log.info(friendships.toString());
        return List.of();
        //return friendships.stream()
        //        .map(UserFriendshipResponse::fromFriendship)
        //        .toList();
    }




}
