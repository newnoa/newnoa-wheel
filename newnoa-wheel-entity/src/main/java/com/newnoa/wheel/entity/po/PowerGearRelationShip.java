package com.newnoa.wheel.entity.po;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/12 16:53
 */
@Data
public class PowerGearRelationShip {
    @RelationshipId
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    private String indexName;

    private PowerClient powerClient;

    private GearServer gearServer;

    private String relation;
}
