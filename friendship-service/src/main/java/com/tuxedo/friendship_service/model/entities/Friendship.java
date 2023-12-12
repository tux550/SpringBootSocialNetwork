package com.tuxedo.friendship_service.model.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;


@RelationshipProperties
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friendship {
    @RelationshipId @GeneratedValue
    private Long id;
    @TargetNode
    private User friend;
    private String status;

    @Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", friend=" + friend +
                ", status='" + status + '\'' +
                '}';
    }
}
