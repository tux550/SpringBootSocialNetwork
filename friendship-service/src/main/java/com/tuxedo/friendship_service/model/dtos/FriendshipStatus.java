package com.tuxedo.friendship_service.model.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendshipStatus {
    private String userId;
    private String status;
}
