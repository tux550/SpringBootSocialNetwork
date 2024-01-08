package com.tuxedo.social_service.model.dtos;

import com.tuxedo.social_service.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {
    private UUID userId;

    public User toUser() {
        return User.builder()
                .userId(userId)
                .build();
    }
}
