package com.tuxedo.social_service.model.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;


@RelationshipProperties
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Follow {
    @RelationshipId @GeneratedValue
    private Long id;
    @TargetNode
    private User followTarget;
    private String status;

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", friend=" + followTarget +
                ", status='" + status + '\'' +
                '}';
    }
}
