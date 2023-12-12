package com.tuxedo.friendship_service.repositories;

import com.tuxedo.friendship_service.model.dtos.FriendshipQueryResult;
import com.tuxedo.friendship_service.model.entities.Friendship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

import java.util.List;

public interface FriendshipRepository extends Neo4jRepository<Friendship, Long> {
    // Delete friendship by users
    @Query("MATCH (u1:User)-[f:FRIENDS_WITH]-(u2:User) " +
            "WHERE u1.userId = $userId AND u2.userId = $friendId " +
            "DELETE f")
    void deleteFriendshipByUsers(String userId, String friendId);

    // Get friendships by users
    @Query("MATCH (u1:User)-[friendship:FRIENDS_WITH]-(friend:User) " +
            "WHERE u1.userId = $userId " +
            "RETURN id(friendship) AS id, friend.userId AS friendId, friendship.status AS status")
    List<FriendshipQueryResult> getFriendshipsByUser(String userId);

}
