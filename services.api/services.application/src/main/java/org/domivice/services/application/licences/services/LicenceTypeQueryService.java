package org.domivice.services.application.licences.services;

import org.domivice.services.application.licences.queries.GetLicenceTypeQuery;
import org.domivice.services.application.licences.queries.GetLicenceTypesByName;
import org.domivice.services.domain.entities.LicenceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LicenceTypeQueryService {
    Mono<LicenceType> getLicenceType(GetLicenceTypeQuery query);

    Flux<LicenceType> getLicenceTypesByName(GetLicenceTypesByName query);
}
