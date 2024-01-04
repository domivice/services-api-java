package org.domivice.services.web;

import org.axonframework.test.server.AxonServerContainer;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration
public class ContainerConfiguration {
    @Bean
    @ServiceConnection
    @RestartScope
    public AxonServerContainer axonServerContainer() {
        return new AxonServerContainer(DockerImageName.parse("axoniq/axonserver").asCompatibleSubstituteFor("axoniq/axonserver:latest-dev"));
    }

    @Bean
    @ServiceConnection
    @RestartScope
    public MongoDBContainer mongoDBContainer() {
        return new DomiviceMongoDBContainer("mongo:latest");
    }
}
