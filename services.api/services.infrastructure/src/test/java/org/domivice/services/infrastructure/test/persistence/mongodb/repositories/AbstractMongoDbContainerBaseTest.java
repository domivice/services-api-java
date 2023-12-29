package org.domivice.services.infrastructure.test.persistence.mongodb.repositories;

import org.domivice.services.infrastructure.persistence.mongodb.configurations.MongoConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@ContextConfiguration(classes = MongoConfig.class)
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
@Testcontainers
public abstract class AbstractMongoDbContainerBaseTest {
    @Container
    private static final MongoDBContainer mongoContainer;

    static {
        mongoContainer = new MongoDBContainer("mongo:latest");
        mongoContainer.start();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        String mongoUri = mongoContainer.getReplicaSetUrl() + "?authSource=admin&uuidRepresentation=standard&maxIdleTimeMS=0";
        registry.add("spring.data.mongodb.uri", () -> mongoUri);
        registry.add("spring.data.mongodb.database", () -> "tests");
    }
}
