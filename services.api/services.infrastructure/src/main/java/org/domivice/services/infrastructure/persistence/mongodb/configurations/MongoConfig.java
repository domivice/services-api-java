package org.domivice.services.infrastructure.persistence.mongodb.configurations;

import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.domivice.services.infrastructure.persistence.mongodb.converters.ZonedDateTimeReadConverter;
import org.domivice.services.infrastructure.persistence.mongodb.converters.ZonedDateTimeWriteConverter;
import org.springframework.boot.autoconfigure.mongo.MongoConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "org.domivice.services.infrastructure.persistence.mongodb.repositories")
public class MongoConfig extends AbstractReactiveMongoConfiguration {
    private final MongoConnectionDetails mongoConnectionDetails;

    public MongoConfig(MongoConnectionDetails mongoConnectionDetails) {
        this.mongoConnectionDetails = mongoConnectionDetails;
    }

    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(this.mongoConnectionDetails.getConnectionString());
    }

    @Bean
    public ReactiveMongoDatabaseFactory reactiveMongoDbFactory() {
        return super.reactiveMongoDbFactory();
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoDbFactory());
    }

    @Override
    protected MongoClientSettings mongoClientSettings() {
        return MongoClientSettings.builder()
                .applyConnectionString(this.mongoConnectionDetails.getConnectionString())
                .build();
    }

    @Override
    protected void configureConverters(MongoCustomConversions.MongoConverterConfigurationAdapter adapter) {
        adapter.registerConverter(new ZonedDateTimeReadConverter());
        adapter.registerConverter(new ZonedDateTimeWriteConverter());
    }

    @Override
    protected String getDatabaseName() {
        return this.mongoConnectionDetails.getConnectionString().getDatabase();
    }
}
