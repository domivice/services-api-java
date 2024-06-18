package org.domivice.services.infrastructure.persistence.mongodb.configurations;

import jakarta.annotation.PostConstruct;
import org.domivice.services.infrastructure.persistence.mongodb.documents.LicenceTypeDocument;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
public class LicenceTypeConfiguration extends BaseDocumentConfiguration {
    public LicenceTypeConfiguration(ReactiveMongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }

    @PostConstruct
    public void createIndexes() {
        var indexes = List.of(
            new TextIndexDefinition.TextIndexDefinitionBuilder()
                .onField("name")
                .withDefaultLanguage("none")
                .withLanguageOverride("")
                .withSimpleCollation()
                .named("name_index")
                .build()
        );

        // Use Flux.fromIterable to convert the List to a Flux
        Flux.fromIterable(indexes)
            .flatMap(index -> ensureIndexIfNotExists(index, LicenceTypeDocument.class))
            .then()
            .subscribe(); // Subscribe to initiate the non-blocking operation
    }
}
