package com.tuxedo.social_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFollowResponse {
    private UUID userId;
    private UUID targetId;
    private String status;
}
