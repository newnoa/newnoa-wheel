package com.newnoa.wheel.entity.po;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/10 11:01
 */
@Data
@Builder
public class WheelGearRelationShip {

    @RelationshipId
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    private String indexName;

    private WheelServer wheelServer;

    private GearServer gearServer;

    private String relation;
}
