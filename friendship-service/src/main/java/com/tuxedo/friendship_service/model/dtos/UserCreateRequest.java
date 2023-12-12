package com.tuxedo.friendship_service.model.dtos;

import com.tuxedo.friendship_service.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {
    private String userId;

    static public User toUser(UserCreateRequest userCreateRequest) {
        return User.builder()
                .userId(userCreateRequest.getUserId())
                .build();
    }
}
