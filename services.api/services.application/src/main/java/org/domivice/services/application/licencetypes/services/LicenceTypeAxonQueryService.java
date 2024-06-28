package org.domivice.services.application.licencetypes.services;

import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypeQuery;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypesByNameQuery;
import org.domivice.services.domain.entities.LicenceType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LicenceTypeAxonQueryService implements LicenceTypeQueryService {
    private final QueryGateway queryGateway;

    /**
     * @param query
     * @return
     */
    @Override
    public Mono<LicenceType> getLicenceType(GetLicenceTypeQuery query) {
        return Mono.fromFuture(() -> queryGateway
                .query(query, ResponseTypes.instanceOf(LicenceType.class)))
            .flatMap(Mono::justOrEmpty);
    }

    /**
     * @param query
     * @return
     */
    @Override
    public Flux<LicenceType> getLicenceTypesByName(GetLicenceTypesByNameQuery query) {
        return Mono.fromFuture(() -> queryGateway.query(query, ResponseTypes.multipleInstancesOf(LicenceType.class)))
            .flatMapMany(Flux::fromIterable);
    }
}
