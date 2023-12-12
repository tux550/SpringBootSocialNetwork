package com.tuxedo.comment_service.model.dtos;

import com.tuxedo.comment_service.model.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCommentRequest {
    private String content;
    private String postId;
    private UUID authorId;

    static public Comment toComment(CreateCommentRequest request) {
        return Comment.builder()
                .content(request.getContent())
                .postId(request.getPostId())
                .authorId(request.getAuthorId())
                .build();
    }
}
