package org.domivice.services.application.licenceissuers.services;

import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerByCountryCode;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerByStateCode;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerQuery;
import org.domivice.services.application.licenceissuers.queries.SearchLicenceIssuerQuery;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LicenceIssuerAxonQueryService implements LicenceIssuerQueryService {
    private final QueryGateway queryGateway;

    /**
     * @param query
     * @return
     */
    @Override
    public Mono<LicenceIssuer> getLicenceIssuer(GetLicenceIssuerQuery query) {
        return Mono.fromFuture(() -> queryGateway.query(query, ResponseTypes.instanceOf(LicenceIssuer.class))).
            flatMap(Mono::justOrEmpty);
    }

    /**
     * @param query
     * @return
     */
    @Override
    public Flux<LicenceIssuer> getLicenceIssuerByCountryCode(GetLicenceIssuerByCountryCode query) {
        return Mono.fromFuture(() -> queryGateway.query(query, ResponseTypes.multipleInstancesOf(LicenceIssuer.class)))
            .flatMapMany(Flux::fromIterable);
    }

    /**
     * @param query
     * @return
     */
    @Override
    public Flux<LicenceIssuer> getLicenceIssuerByStateCode(GetLicenceIssuerByStateCode query) {
        return Mono.fromFuture(() -> queryGateway.query(query, ResponseTypes.multipleInstancesOf(LicenceIssuer.class)))
            .flatMapMany(Flux::fromIterable);
    }

    /**
     * @param query
     * @return
     */
    @Override
    public Flux<LicenceIssuer> searchLicenceIssuer(SearchLicenceIssuerQuery query) {
        return Mono.fromFuture(() -> queryGateway.query(query, ResponseTypes.multipleInstancesOf(LicenceIssuer.class)))
            .flatMapMany(Flux::fromIterable);
    }
}
