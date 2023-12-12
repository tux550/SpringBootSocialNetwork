package com.tuxedo.friendship_service.model.dtos;

import com.tuxedo.friendship_service.model.entities.Friendship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFriendshipResponse {
    private String friendId;
    private String status;

    public static UserFriendshipResponse fromFriendship(Friendship friendship) {
        return UserFriendshipResponse.builder()
                .friendId(friendship.getFriend().getUserId())
                .status(friendship.getStatus())
                .build();
    }
}
