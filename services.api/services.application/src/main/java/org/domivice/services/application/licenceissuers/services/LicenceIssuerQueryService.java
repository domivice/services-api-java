package org.domivice.services.application.licenceissuers.services;

import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerByCountryCodeQuery;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerByStateCodeQuery;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerQuery;
import org.domivice.services.application.licenceissuers.queries.SearchLicenceIssuerQuery;
import org.domivice.services.domain.entities.LicenceIssuer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LicenceIssuerQueryService {
    Mono<LicenceIssuer> getLicenceIssuer(GetLicenceIssuerQuery query);

    Flux<LicenceIssuer> getLicenceIssuerByCountryCode(GetLicenceIssuerByCountryCodeQuery query);

    Flux<LicenceIssuer> getLicenceIssuerByStateCode(GetLicenceIssuerByStateCodeQuery query);

    Flux<LicenceIssuer> searchLicenceIssuer(SearchLicenceIssuerQuery query);
}
