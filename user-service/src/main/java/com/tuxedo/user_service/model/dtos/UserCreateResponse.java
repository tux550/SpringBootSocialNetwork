package com.tuxedo.user_service.model.dtos;


import com.tuxedo.user_service.model.entities.User;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateResponse {
    private UUID id;

    static public UserCreateResponse fromUser(User user) {
        return UserCreateResponse.builder()
                .id(user.getId())
                .build();
    }
}
