package com.newnoa.wheel.dao.mongo.impl;

import com.mongodb.client.MongoCollection;
import com.newnoa.wheel.dao.mongo.NewNoaMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/10 12:24
 */
@Slf4j
public abstract class AbstractNewNoaMongoRepository<T> implements NewNoaMongoRepository<T> {
    private Class<T> clazz;

    private MongoTemplate mongoTemplate;

    protected void initCollection(MongoTemplate mongoTemplate, Class<T> clazz) {
        this.mongoTemplate = mongoTemplate;
        this.clazz = clazz;
        boolean collectionExists = mongoTemplate.collectionExists(clazz);
        if (!collectionExists) {
            MongoCollection<Document> collection = mongoTemplate.createCollection(clazz);
            log.info(collection.toString());
        } else {
            log.info("mongodb collection: {} is exists.ignore create.", clazz.getName());
        }
    }

    @Override
    public T save(T t) {
        return this.mongoTemplate.save(t);
    }

    @Override
    public T deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return this.mongoTemplate.findAndRemove(query, this.clazz);
    }
}
