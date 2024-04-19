package com.newnoa.wheel.dao.neo4j;

import com.newnoa.wheel.entity.po.PowerGearRelationShip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/12 19:29
 */
@Repository
public interface PowerGearRelationShipRepository extends Neo4jRepository<PowerGearRelationShip, String> {
}
