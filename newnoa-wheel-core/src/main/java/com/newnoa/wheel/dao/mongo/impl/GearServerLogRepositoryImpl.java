package com.newnoa.wheel.dao.mongo.impl;

import com.newnoa.wheel.dao.mongo.GearServerLogRepository;
import com.newnoa.wheel.entity.po.GearServerLog;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/10 12:04
 */
@Repository
@Slf4j
public class GearServerLogRepositoryImpl extends AbstractNewNoaMongoRepository<GearServerLog> implements GearServerLogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    @Override
    public void init() {
        super.initCollection(mongoTemplate, GearServerLog.class);
    }

}
