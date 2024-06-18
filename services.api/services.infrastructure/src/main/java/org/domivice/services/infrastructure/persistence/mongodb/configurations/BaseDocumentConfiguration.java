package org.domivice.services.infrastructure.persistence.mongodb.configurations;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.index.IndexDefinition;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class BaseDocumentConfiguration {
    private final ReactiveMongoTemplate mongoTemplate;

    protected <D> Mono<Void> ensureIndexIfNotExists(IndexDefinition index, Class<D> documentType) {
        return mongoTemplate.indexOps(documentType)
            .getIndexInfo()
            .collectList()
            .flatMap(existingIndexes -> {
                boolean indexExists = existingIndexes.stream()
                    .anyMatch(existingIndex -> existingIndex.getName().equals(index.getIndexOptions().get("name")));
                if (!indexExists) {
                    return mongoTemplate.indexOps(documentType).ensureIndex(index).then();
                } else {
                    return Mono.empty();
                }
            });
    }
}
