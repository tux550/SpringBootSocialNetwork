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
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    final private CommentService commentService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCommentResponse createComment(@RequestBody CreateCommentRequest request) {
        return commentService.createComment(request);
    }

    @GetMapping("/{id}")
    public CommentResponse getComment(@PathVariable("id") String commentId) {
        return commentService.getComment(commentId);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") String commentId) {
        commentService.deleteComment(commentId);
    }

    @GetMapping("/post/{postId}/comments")
    public List<CommentResponse> getAllCommentsByPostId(@PathVariable("postId") String postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/user/{authorId}/comments")
    public List<CommentResponse> getAllCommentsByAuthorId(@PathVariable("authorId") UUID authorId) {
        return commentService.getAllCommentsByAuthorId(authorId);
    }
}
