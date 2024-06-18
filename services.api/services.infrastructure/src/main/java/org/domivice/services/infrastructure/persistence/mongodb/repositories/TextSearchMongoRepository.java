package org.domivice.services.infrastructure.persistence.mongodb.repositories;

import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface TextSearchMongoRepository {
    <T, D> Flux<T> textSearch(Class<T> entityType, Class<D> documentType, String text, Pageable pageable);
}
