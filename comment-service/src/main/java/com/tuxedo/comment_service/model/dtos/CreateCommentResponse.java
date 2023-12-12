package com.tuxedo.comment_service.model.dtos;

import com.tuxedo.comment_service.model.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCommentResponse {
    private String id;

    static public CreateCommentResponse fromComment(Comment comment) {
        return CreateCommentResponse.builder()
                .id(comment.getId())
                .build();
    }
}
