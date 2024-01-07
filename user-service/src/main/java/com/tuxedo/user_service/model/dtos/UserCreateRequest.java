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
public class UserCreateRequest {
    private String firstName;
    private String lastName;
    private String email;

    public User toUser() {
        return User.builder()
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .email(this.getEmail())
                .build();
    }
}
