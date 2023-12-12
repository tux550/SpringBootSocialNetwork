package com.tuxedo.postservice.services;

import com.tuxedo.postservice.model.dtos.CreatePostRequest;
import com.tuxedo.postservice.model.dtos.CreatePostResponse;
import com.tuxedo.postservice.model.dtos.PostByAuthorRequest;
import com.tuxedo.postservice.model.dtos.PostResponse;
import com.tuxedo.postservice.model.entites.Post;
import com.tuxedo.postservice.repositories.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public CreatePostResponse createPost(CreatePostRequest request) {
        var post = CreatePostRequest.toPost(request);
        log.info("Creating post: {}", post);
        postRepository.save(post);
        return CreatePostResponse.fromPost(post);
    }

    public void deletePost(String postId) {
        log.info("Deleting post with id: {}", postId);
        postRepository.deleteById(postId);
    }

    public PostResponse getPostById(String postId) {
        log.info("Getting post with id: {}", postId);
        var post = postRepository.findById(postId).orElseThrow();
        return PostResponse.fromPost(post);
    }

    public List<PostResponse> getAllPostsByAuthorId(PostByAuthorRequest request) {
        log.info("Getting all posts by author with id: {}", request.getAuthorId());
        var posts = postRepository.findAllByAuthorId(request.getAuthorId());
        List<PostResponse> postResponses = new ArrayList<>();
        posts.forEach(post -> postResponses.add(PostResponse.fromPost(post)));
        return postResponses;
    }

}
