package com.tuxedo.postservice.model.dtos;

import com.tuxedo.postservice.model.entites.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    private String id;
    private String title;
    private String content;
    private String authorId;

    static public PostResponse fromPost(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .authorId(post.getAuthorId())
                .build();
    }
}
