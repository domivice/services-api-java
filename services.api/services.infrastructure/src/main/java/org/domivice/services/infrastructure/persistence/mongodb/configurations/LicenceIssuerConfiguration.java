package org.domivice.services.infrastructure.persistence.mongodb.configurations;

import jakarta.annotation.PostConstruct;
import org.domivice.services.infrastructure.persistence.mongodb.documents.LicenceIssuerDocument;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
public class LicenceIssuerConfiguration extends BaseDocumentConfiguration {
    public LicenceIssuerConfiguration(ReactiveMongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }

    @PostConstruct
    public void createIndexes() {
        var indexes = List.of(
            new Index()
                .on("issuingCountryCode", Sort.Direction.ASC)
                .named("issuingCountryCode_index"),
            new Index()
                .on("issuingStateCode", Sort.Direction.ASC)
                .named("issuingStateCode_index"),
            new Index()
                .on("licenceTypeId", Sort.Direction.ASC)
                .named("licenceTypeId_index"),
            new TextIndexDefinition.TextIndexDefinitionBuilder()
                .onField("issuerName")
                .withDefaultLanguage("none")
                .withLanguageOverride("")
                .withSimpleCollation()
                .named("issuerName_text_index")
                .build()
        );

        // Use Flux.fromIterable to convert the List to a Flux
        Flux.fromIterable(indexes)
            .flatMap(index -> ensureIndexIfNotExists(index, LicenceIssuerDocument.class))
            .then()
            .subscribe(); // Subscribe to initiate the non-blocking operation
    }
}
