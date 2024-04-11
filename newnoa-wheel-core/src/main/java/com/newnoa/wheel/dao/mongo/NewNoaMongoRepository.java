package com.newnoa.wheel.dao.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/11 14:42
 */
public interface NewNoaMongoRepository<T> {
    void init();

    T save(T t);

    T deleteById(String id);
}
