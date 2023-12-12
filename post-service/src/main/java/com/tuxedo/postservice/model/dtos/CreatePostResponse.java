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
public class CreatePostResponse {
    private String id;

    static public CreatePostResponse fromPost(Post post) {
        return CreatePostResponse.builder()
                .id(post.getId())
                .build();
    }
}
