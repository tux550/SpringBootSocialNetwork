package com.tuxedo.post_service.model.dtos;

import com.tuxedo.post_service.model.entites.Post;
import lombok.*;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostRequest {
    private String title;
    private String content;
    private UUID authorId;


    static public Post toPost(CreatePostRequest request) {
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .authorId(request.getAuthorId())
                .build();
    }
}
