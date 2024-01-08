package com.tuxedo.social_service.model.dtos;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowQueryResult {
    private Long id;
    private UUID userId;
    private UUID targetId;
    private String status;

    public UserFollowResponse toUserFollowResponse() {
        return UserFollowResponse.builder()
                .userId(userId)
                .targetId(targetId)
                .status(status)
                .build();
    }
}
