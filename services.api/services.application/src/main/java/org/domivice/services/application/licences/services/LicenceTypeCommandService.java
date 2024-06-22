package org.domivice.services.application.licences.services;

import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licences.commands.DeleteLicenceTypeCommand;
import org.domivice.services.application.licences.commands.UpdateLicenceTypeCommand;
import org.domivice.services.domain.entities.LicenceType;
import reactor.core.publisher.Mono;

public interface LicenceTypeCommandService {
    Mono<LicenceType> addLicenceType(CreateLicenceTypeCommand command);
    Mono<LicenceType> updateLicenceType(UpdateLicenceTypeCommand command);
    Mono<Void> deleteLicenceType(DeleteLicenceTypeCommand command);
}
