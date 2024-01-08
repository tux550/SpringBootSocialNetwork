package com.tuxedo.social_service.repositories;

import com.tuxedo.social_service.model.dtos.FollowQueryResult;
import com.tuxedo.social_service.model.entities.Follow;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.UUID;

public interface FollowRepository extends Neo4jRepository<Follow, Long> {
    // Delete friendship by users
    @Query("MATCH (u1:User)-[f:FOLLOWS]->(u2:User) " +
            "WHERE u1.userId = $userId AND u2.userId = $targetId " +
            "DELETE f")
    void deleteFollowByUserIdAndTargetId(UUID userId, UUID targetId);

    // Update follow status
    @Query("MATCH (u1:User)-[f:FOLLOWS]->(u2:User) " +
            "WHERE u1.userId = $userId AND u2.userId = $targetId " +
            "SET f.status = $status")
    void updateFollowStatus(UUID userId, UUID targetId, String status);

    // Find if user follows target
    @Query("MATCH (u1:User)-[f:FOLLOWS]->(u2:User) " +
            "WHERE u1.userId = $userId AND u2.userId = $targetId " +
            "RETURN id(f) AS id, u1.userId AS userId, u2.userId AS targetId, f.status AS status")
    List<FollowQueryResult> getFollow(UUID userId, UUID targetId);

    // Get follows of user
    @Query("MATCH (u1:User)-[f:FOLLOWS]->(u2:User) " +
            "WHERE u1.userId = $userId " +
            "RETURN id(f) AS id, u1.userId AS userId, u2.userId AS targetId, f.status AS status")
    List<FollowQueryResult> getFollowsByUserId(UUID userId);

    // Get followers of user
    @Query("MATCH (u1:User)<-[f:FOLLOWS]-(u2:User) " +
            "WHERE u1.userId = $userId " +
            "RETURN id(f) AS id, u1.userId AS userId, u2.userId AS targetId, f.status AS status")
    List<FollowQueryResult> getFollowersByUserId(UUID userId);

}
