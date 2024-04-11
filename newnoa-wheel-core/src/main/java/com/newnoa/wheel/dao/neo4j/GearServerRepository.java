package com.newnoa.wheel.dao.neo4j;

import com.newnoa.wheel.entity.po.GearServer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/8 16:58
 */
@Repository
public interface GearServerRepository extends Neo4jRepository<GearServer, String> {
}
