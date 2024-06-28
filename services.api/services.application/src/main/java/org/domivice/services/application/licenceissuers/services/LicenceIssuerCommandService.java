package org.domivice.services.application.licenceissuers.services;

import jakarta.validation.Valid;
import org.domivice.services.application.licenceissuers.commands.CreateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.commands.DeleteLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.commands.UpdateLicenceIssuerCommand;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Validated
public interface LicenceIssuerCommandService {
    Mono<LicenceIssuer> addLicenceIssuer(@Valid CreateLicenceIssuerCommand command);
    Mono<LicenceIssuer> updateLicenceIssuer(@Valid UpdateLicenceIssuerCommand command);
    Mono<Void> deleteLicenceIssuer(@Valid DeleteLicenceIssuerCommand command);
}
