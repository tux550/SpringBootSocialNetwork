package com.tuxedo.postservice.model.dtos;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostRequest {
    private String title;
    private String content;
    private String authorId;
}
