package org.domivice.services.infrastructure.persistence.mongodb.configurations;

import org.domivice.services.infrastructure.persistence.mongodb.converters.ZonedDateTimeReadConverter;
import org.domivice.services.infrastructure.persistence.mongodb.converters.ZonedDateTimeWriteConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "org.domivice.services.infrastructure.persistence.mongodb.repositories")
public class MongoConfig {
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(
                new ZonedDateTimeReadConverter(),
                new ZonedDateTimeWriteConverter()
        ));
    }
}
