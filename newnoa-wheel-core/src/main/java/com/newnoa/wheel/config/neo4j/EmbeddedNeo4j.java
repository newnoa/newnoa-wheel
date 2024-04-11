package com.newnoa.wheel.config.neo4j;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.nio.file.Path;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.configuration.GraphDatabaseSettings;
import org.neo4j.configuration.connectors.BoltConnector;
import org.neo4j.configuration.connectors.HttpConnector;
import org.neo4j.configuration.helpers.SocketAddress;
import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * newnoa-gear.
 *
 * @author: Neowei
 * @date: 2024/4/7 18:47
 */

@Slf4j
@Configuration
@ConditionalOnClass(DatabaseManagementService.class)
public class EmbeddedNeo4j {

    public EmbeddedNeo4j() {
    }

    private DatabaseManagementService databaseManagementService;

    @PostConstruct
    public void startup() {
        log.info("neo4j init start");
        databaseManagementService =
                new DatabaseManagementServiceBuilder(Path.of("newnoa-gear-graphdb")).setConfig(GraphDatabaseSettings.default_listen_address, new SocketAddress("0.0.0.0"))
                        .setConfig(BoltConnector.enabled, true).setConfig(HttpConnector.enabled, true).build();
        log.info("neo4j init finish");
    }

    @PreDestroy
    public void shutdown() {
        if (databaseManagementService != null) {
            databaseManagementService.shutdown();
        }
    }
}
