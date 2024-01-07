package com.tuxedo.user_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + firstName + ", email=" + email + "}";
    }
}
