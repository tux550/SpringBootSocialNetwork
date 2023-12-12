package com.tuxedo.post_service.controllers;

import com.tuxedo.post_service.model.dtos.CreatePostRequest;
import com.tuxedo.post_service.model.dtos.CreatePostResponse;
import com.tuxedo.post_service.model.dtos.PostByAuthorRequest;
import com.tuxedo.post_service.model.dtos.PostResponse;
import com.tuxedo.post_service.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PostControllers {
    private final PostService postService;

    @PostMapping("/api/v1/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@RequestBody CreatePostRequest request) {
        return postService.createPost(request);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public void deletePost(@PathVariable("id") String postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/api/v1/posts")
    public List<PostResponse> getAllPostsByAuthorId(@RequestBody PostByAuthorRequest request) {
        return postService.getAllPostsByAuthorId(request);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponse getPostById(@PathVariable("id") String postId) {
        return postService.getPostById(postId);
    }
}
