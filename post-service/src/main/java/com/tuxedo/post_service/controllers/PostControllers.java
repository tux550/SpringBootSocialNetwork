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
import java.util.UUID;

@RestController
@RequestMapping("/posts-service/v1")
@RequiredArgsConstructor
public class PostControllers {
    private final PostService postService;

//    @GetMapping("/posts")
//    public List<PostResponse> getAllPostsByAuthorId(@RequestBody PostByAuthorRequest request) {
//        return postService.getAllPostsByAuthorId(request);
//    }

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@RequestBody CreatePostRequest request) {
        return postService.createPost(request);
    }

    @GetMapping("/posts/{id}")
    public PostResponse getPostById(@PathVariable("id") String postId) {
        return postService.getPostById(postId);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") String postId) {
        postService.deletePost(postId);
    }


    @GetMapping("/users/{authorId}/posts")
    public List<PostResponse> getAllPostsByAuthorId(@PathVariable("authorId") UUID authorId) {
        return postService.getAllPostsByAuthorId(authorId);
    }
}
