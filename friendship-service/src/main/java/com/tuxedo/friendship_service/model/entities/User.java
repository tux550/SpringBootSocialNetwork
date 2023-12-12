package com.tuxedo.friendship_service.model.entities;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.Set;


@Node
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    private String userId;
    @Relationship(type = "FRIENDS_WITH")
    private Set<User> friends;

    public void friendsWith(User friend) {
        if (this.friends == null){
            this.friends = Set.of();
        }
        this.friends.add(friend);
    }
}
