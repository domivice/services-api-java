package org.domivice.services.infrastructure.test.persistence.mongodb;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.MongoDBContainer;

@TestConfiguration
public class ContainerConfiguration {
    @Bean
    @ServiceConnection
    @RestartScope
    @Profile("!local")
    public MongoDBContainer mongoDBContainer() {
        return new DomiviceMongoDBContainer("mongo:latest");
    }
}
