package com.tuxedo.friendship_service.repositories;

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

    // Get all friendships where user is either userId or friendId
    //@Query("MATCH (u1:User)-[f:FRIENDS_WITH]-(u2:User) " +
    //        "WHERE u1.userId = $userId OR u2.userId = $userId " +
    //        "RETURN f")

    // Get friendships by users
    @Query("MATCH (u1:User)-[f:FRIENDS_WITH]-(u2:User) " +
            "WHERE u1.userId = $userId " +
            "RETURN f")
    Iterable<Friendship> getFriendshipsByUsers(String userId);

    // Get friendship by users
    @Query("MATCH (u1:User)-[f:FRIENDS_WITH]-(u2:User) " +
            "WHERE u1.userId = $userId " +
            "RETURN f")
    Friendship getFriendshipByUsers(String userId, String friendId);
}
