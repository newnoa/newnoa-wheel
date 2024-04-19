package com.newnoa.wheel.dao.neo4j;

import com.newnoa.wheel.entity.po.PowerClient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/12 19:27
 */
@Repository
public interface PowerClientRepository extends Neo4jRepository<PowerClient, String> {
}
