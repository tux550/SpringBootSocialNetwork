package com.tuxedo.postservice.model.dtos;

import com.tuxedo.postservice.model.entites.Post;
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
