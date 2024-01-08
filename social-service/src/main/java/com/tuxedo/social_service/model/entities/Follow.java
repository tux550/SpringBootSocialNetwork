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
    public static class Status {
        public static final String PENDING = "PENDING";
        public static final String ACCEPTED = "ACCEPTED";
    }

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
