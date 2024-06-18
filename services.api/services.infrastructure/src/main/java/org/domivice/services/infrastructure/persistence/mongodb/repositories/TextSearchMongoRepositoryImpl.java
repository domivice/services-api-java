package org.domivice.services.infrastructure.persistence.mongodb.repositories;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Repository
public class TextSearchMongoRepositoryImpl implements TextSearchMongoRepository {
    private final ReactiveMongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;

    @Override
    public <T, D> Flux<T> textSearch(Class<T> entityType, Class<D> documentType, String text, Pageable pageable) {
        return mongoTemplate.find(TextQuery.queryText(
                new TextCriteria().matchingAny(text))
            .with(pageable), documentType
        ).map(d -> modelMapper.map(d, entityType));
    }
}
