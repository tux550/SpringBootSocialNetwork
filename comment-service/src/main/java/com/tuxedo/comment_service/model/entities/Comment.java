package com.tuxedo.comment_service.model.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    private String id;
    private String content;
    private UUID authorId; // Comment author
    private String postId;
    @CreatedDate
    private Long createdAt;
    @LastModifiedDate
    private Long lastModifiedAt;
    @Version
    private Long version;
}
