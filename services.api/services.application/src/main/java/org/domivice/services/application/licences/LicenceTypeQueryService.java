package org.domivice.services.application.licences;

import org.domivice.services.application.licences.queries.GetLicenceTypeQuery;
import org.domivice.services.domain.entities.LicenceType;
import reactor.core.publisher.Mono;

public interface LicenceTypeQueryService {
    Mono<LicenceType> getLicenceType(GetLicenceTypeQuery query);
}
