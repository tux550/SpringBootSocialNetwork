package com.tuxedo.comment_service.repositories;

import com.tuxedo.comment_service.model.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface CommentRepository extends MongoRepository<Comment, String> {
    @Query("{ 'postId' : ?0 }")
    Iterable<Comment> findAllByPostId(String postId);

    @Query("{ 'authorId' : ?0 }")
    Iterable<Comment> findAllByAuthorId(UUID authorId);
}
