package org.domivice.services.application.licencetypes.services;

import org.domivice.services.application.licencetypes.queries.GetLicenceTypeQuery;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypesByNameQuery;
import org.domivice.services.domain.entities.LicenceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LicenceTypeQueryService {
    Mono<LicenceType> getLicenceType(GetLicenceTypeQuery query);

    Flux<LicenceType> getLicenceTypesByName(GetLicenceTypesByNameQuery query);
}
