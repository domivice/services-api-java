package org.domivice.services.infrastructure.test.persistence.mongodb;

import org.domivice.services.infrastructure.persistence.mongodb.configurations.MongoConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import({ContainerConfiguration.class, MongoConfig.class})
public class AbstractFunctionalTests {
}
