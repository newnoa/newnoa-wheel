package com.newnoa.wheel.dao.neo4j;

import com.newnoa.wheel.entity.po.WheelGearRelationShip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/10 11:01
 */
@Repository
public interface WheelGearRelationShipRepository extends Neo4jRepository<WheelGearRelationShip, String> {
}
