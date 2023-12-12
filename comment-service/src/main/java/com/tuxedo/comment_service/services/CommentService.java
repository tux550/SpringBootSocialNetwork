package com.tuxedo.comment_service.services;
import com.tuxedo.comment_service.model.dtos.CommentResponse;
import com.tuxedo.comment_service.model.dtos.CreateCommentRequest;
import com.tuxedo.comment_service.model.dtos.CreateCommentResponse;
import  com.tuxedo.comment_service.repositories.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;

    public CreateCommentResponse createComment(CreateCommentRequest request) {
        var comment = CreateCommentRequest.toComment(request);
        log.info("Creating comment: {}", comment);
        commentRepository.save(comment);
        return CreateCommentResponse.fromComment(comment);
    }

    public void deleteComment(String commentId) {
        log.info("Deleting comment with id: {}", commentId);
        commentRepository.deleteById(commentId);
    }

    public CommentResponse getComment(String id) {
        log.info("Getting comment with id: {}", id);
        var comment = commentRepository.findById(id).orElseThrow();
        return CommentResponse.fromComment(comment);
    }

    public List<CommentResponse> getAllCommentsByPostId(String postId) {
        log.info("Getting all comments by post with id: {}", postId);
        var comments = commentRepository.findAllByPostId(postId);
        List<CommentResponse> commentResponses = new ArrayList<>();
        comments.forEach(comment -> commentResponses.add(CommentResponse.fromComment(comment)));
        return commentResponses;
    }

    public List<CommentResponse> getAllCommentsByAuthorId(UUID authorId) {
        log.info("Getting all comments by author with id: {}", authorId);
        var comments = commentRepository.findAllByAuthorId(authorId);
        List<CommentResponse> commentResponses = new ArrayList<>();
        comments.forEach(comment -> commentResponses.add(CommentResponse.fromComment(comment)));
        return commentResponses;
    }

}
