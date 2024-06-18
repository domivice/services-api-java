package org.domivice.services.application.licenceissuers.services;

import org.domivice.services.application.licenceissuers.commands.CreateLicenceIssuerCommand;
import org.domivice.services.domain.entities.LicenceIssuer;
import reactor.core.publisher.Mono;

public interface LicenceIssuerCommandService {
    Mono<LicenceIssuer> addLicenceIssuer(CreateLicenceIssuerCommand command);
}
