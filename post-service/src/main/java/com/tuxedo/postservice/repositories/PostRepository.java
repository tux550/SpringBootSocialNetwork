package com.tuxedo.postservice.repositories;
import com.tuxedo.postservice.model.entites.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;


public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'authorId': ?0 }")
    Iterable<Post> findAllByAuthorId(UUID authorId);
}
