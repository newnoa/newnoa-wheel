package com.newnoa.wheel.dao.neo4j;

import com.newnoa.wheel.entity.po.PowerWheelRelationShip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/12 19:31
 */
@Repository
public interface PowerWheelRelationShipRepository extends Neo4jRepository<PowerWheelRelationShip, String> {
}
