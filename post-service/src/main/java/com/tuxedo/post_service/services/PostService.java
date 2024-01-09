package com.tuxedo.post_service.services;

import com.tuxedo.post_service.model.dtos.CreatePostRequest;
import com.tuxedo.post_service.model.dtos.CreatePostResponse;
import com.tuxedo.post_service.model.dtos.PostByAuthorRequest;
import com.tuxedo.post_service.model.dtos.PostResponse;
import com.tuxedo.post_service.repositories.PostRepository;
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

    //public List<PostResponse> getAllPostsByAuthorId(PostByAuthorRequest request) {
    public List<PostResponse> getAllPostsByAuthorId(UUID authorId) {
        log.info("Getting all posts by author with id: {}", authorId);
        var posts = postRepository.findAllByAuthorId(authorId);
        List<PostResponse> postResponses = new ArrayList<>();
        posts.forEach(post -> postResponses.add(PostResponse.fromPost(post)));
        return postResponses;
    }

}
