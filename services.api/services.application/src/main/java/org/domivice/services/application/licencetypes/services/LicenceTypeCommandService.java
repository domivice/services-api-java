package org.domivice.services.application.licencetypes.services;

import org.domivice.services.application.licencetypes.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.commands.DeleteLicenceTypeCommand;
import org.domivice.services.application.licencetypes.commands.UpdateLicenceTypeCommand;
import org.domivice.services.domain.entities.LicenceType;
import reactor.core.publisher.Mono;

public interface LicenceTypeCommandService {
    Mono<LicenceType> addLicenceType(CreateLicenceTypeCommand command);

    Mono<LicenceType> updateLicenceType(UpdateLicenceTypeCommand command);

    Mono<Void> deleteLicenceType(DeleteLicenceTypeCommand command);
}
