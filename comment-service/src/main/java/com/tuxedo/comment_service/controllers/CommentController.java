package com.tuxedo.comment_service.controllers;
import com.tuxedo.comment_service.model.dtos.CommentResponse;
import com.tuxedo.comment_service.model.dtos.CreateCommentRequest;
import com.tuxedo.comment_service.model.dtos.CreateCommentResponse;
import com.tuxedo.comment_service.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CommentController {
    final private CommentService commentService;

    @PostMapping("/api/v1/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCommentResponse createComment(@RequestBody CreateCommentRequest request) {
        return commentService.createComment(request);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentResponse getComment(@PathVariable("id") String commentId) {
        return commentService.getComment(commentId);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteComment(@PathVariable("id") String commentId) {
        commentService.deleteComment(commentId);
    }

    @GetMapping("/api/v1/post/{postId}/comments")
    public List<CommentResponse> getAllCommentsByPostId(@PathVariable("postId") String postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/api/v1/user/{authorId}/comments")
    public List<CommentResponse> getAllCommentsByAuthorId(@PathVariable("authorId") UUID authorId) {
        return commentService.getAllCommentsByAuthorId(authorId);
    }
}
