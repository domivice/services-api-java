package org.domivice.services.infrastructure.persistence.mongodb.configurations;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.domivice.services.infrastructure.persistence.mongodb.converters.ZonedDateTimeReadConverter;
import org.domivice.services.infrastructure.persistence.mongodb.converters.ZonedDateTimeWriteConverter;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;
    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(new ConnectionString(mongoUri));
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
                .applyConnectionString(new ConnectionString(mongoUri))
                .build();
    }

    @Override
    protected void configureConverters(MongoCustomConversions.MongoConverterConfigurationAdapter adapter) {
        adapter.registerConverter(new ZonedDateTimeReadConverter());
        adapter.registerConverter(new ZonedDateTimeWriteConverter());
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
