package org.domivice.services.application.licences;

import org.domivice.domain.entities.LicenceType;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import reactor.core.publisher.Mono;

public interface LicenceTypeCommandService {
    Mono<LicenceType> addLicenceType(CreateLicenceTypeCommand command);
}
