package com.tuxedo.post_service.repositories;
import com.tuxedo.post_service.model.entites.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;


public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'authorId': ?0 }")
    Iterable<Post> findAllByAuthorId(UUID authorId);
}
