package com.tuxedo.friendship_service.model.entities;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;


@Node
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue
    private Long id;
    private String userId;
    @Relationship(type = "FRIENDS_WITH", direction = Relationship.Direction.OUTGOING)
    private Set<Friendship> friends;

    public void addFriend(Friendship friendship) {
        if (friends == null) {
            friends = Set.of();
        }
        friends.add(friendship);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", friends=" + friends +
                '}';
    }
}
