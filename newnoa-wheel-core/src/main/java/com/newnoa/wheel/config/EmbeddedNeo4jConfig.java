package com.newnoa.wheel.config;

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

/**
 * newnoa-gear.
 *
 * @author Neowei
 * @since 2024/4/7 18:47
 */

@Slf4j
@Configuration
@ConditionalOnClass(DatabaseManagementService.class)
public class EmbeddedNeo4jConfig {

    public EmbeddedNeo4jConfig() {
    }

    private DatabaseManagementService databaseManagementService;

    @PostConstruct
    public void startup() {
        log.info("neo4j init start");
        databaseManagementService = new DatabaseManagementServiceBuilder(
                Path.of(System.getProperty("user.dir") + "/newnoa-gear-graphdb")).setConfig(
                        GraphDatabaseSettings.default_listen_address, new SocketAddress("0.0.0.0"))
                .setConfig(BoltConnector.enabled, true).setConfig(HttpConnector.enabled, false).build();
        log.info("neo4j init finish");
    }

    @PreDestroy
    public void shutdown() {
        if (databaseManagementService != null) {
            databaseManagementService.shutdown();
        }
    }
}
