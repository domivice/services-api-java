package org.domivice.services.application.licencetypes.services;

import jakarta.validation.Valid;
import org.domivice.services.application.licencetypes.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.commands.DeleteLicenceTypeCommand;
import org.domivice.services.application.licencetypes.commands.UpdateLicenceTypeCommand;
import org.domivice.services.domain.entities.LicenceType;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Validated
public interface LicenceTypeCommandService {
    Mono<LicenceType> addLicenceType(@Valid CreateLicenceTypeCommand command);

    Mono<LicenceType> updateLicenceType(@Valid UpdateLicenceTypeCommand command);

    Mono<Void> deleteLicenceType(DeleteLicenceTypeCommand command);
}
