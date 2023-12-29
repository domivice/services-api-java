package org.domivice.services.infrastructure.test.persistence.mongodb.repositories;

import org.domivice.services.infrastructure.persistence.mongodb.configurations.MongoConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
public class MongoRepositoryTests {
    @Container
    private static final MongoDBContainer mongoContainer = new MongoDBContainer("mongo:latest");

    @BeforeAll
    static void beforeAll() {
        mongoContainer.start();
    }

    @AfterAll
    static void afterAll() {
        mongoContainer.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        String mongoUri = mongoContainer.getReplicaSetUrl() + "?authSource=admin&uuidRepresentation=standard";
        registry.add("spring.data.mongodb.uri", () -> mongoUri);
        registry.add("spring.data.mongodb.database", () -> "tests");
    }
}
