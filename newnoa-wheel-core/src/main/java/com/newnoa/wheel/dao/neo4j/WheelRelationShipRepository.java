package com.newnoa.wheel.dao.neo4j;

import com.newnoa.wheel.entity.po.WheelRelationShip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/12 20:12
 */
@Repository
public interface WheelRelationShipRepository extends Neo4jRepository<WheelRelationShip, String> {
}
