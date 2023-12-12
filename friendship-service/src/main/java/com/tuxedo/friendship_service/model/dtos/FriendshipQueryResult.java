package com.tuxedo.friendship_service.model.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendshipQueryResult {
    private Long id;
    private String friendId;
    private String status;
}
