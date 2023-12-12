package com.tuxedo.post_service.model.entites;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private UUID authorId;
    @CreatedDate
    private Long createdAt;
    @LastModifiedDate
    private Long lastModifiedAt;
    @Version
    private Long version;
}
