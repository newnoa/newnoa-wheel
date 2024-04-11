package com.newnoa.wheel.dao.neo4j;

import com.newnoa.wheel.entity.po.WheelGearRelationShip;
import com.newnoa.wheel.entity.po.WheelServer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/8 17:29
 */
@Repository
public interface WheelServerRepository extends Neo4jRepository<WheelServer, String> {
}
