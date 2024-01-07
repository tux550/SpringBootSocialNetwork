package com.tuxedo.user_service.model.dtos;

import com.tuxedo.user_service.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGetResponse {
    private String firstName;
    private String lastName;
    private String email;

    public static UserGetResponse fromUser(User user) {
        return UserGetResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
