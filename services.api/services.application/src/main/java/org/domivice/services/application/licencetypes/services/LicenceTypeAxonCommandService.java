package org.domivice.services.application.licencetypes.services;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.domivice.services.application.common.commands.BaseCommand;
import org.domivice.services.application.licencetypes.LicenceTypeRepository;
import org.domivice.services.application.licencetypes.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.commands.DeleteLicenceTypeCommand;
import org.domivice.services.application.licencetypes.commands.UpdateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypeQuery;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.domain.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenceTypeAxonCommandService implements LicenceTypeCommandService {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
    private final LicenceTypeRepository licenceTypeRepository;

    @Override
    public Mono<LicenceType> addLicenceType(CreateLicenceTypeCommand command) {
        return sendCommandAndQueryResult(command);
    }

    public Mono<LicenceType> updateLicenceType(UpdateLicenceTypeCommand command) {
        return checkIfLicenceTypeExists(command.getAggregateId())
            .flatMap(exists -> sendCommandAndQueryResult(command));
    }

    public Mono<Void> deleteLicenceType(DeleteLicenceTypeCommand command) {
        return checkIfLicenceTypeExists(command.getAggregateId())
            .flatMap(exits -> Mono.fromFuture(commandGateway.send(command)));
    }

    private Mono<Boolean> checkIfLicenceTypeExists(UUID licenceTypeId) {
        return licenceTypeRepository.existsById(licenceTypeId)
            .flatMap(exists -> {
                if (exists.equals(Boolean.FALSE)) {
                    return Mono.error(new NotFoundException("Licence type with id " + licenceTypeId + " not found"));
                }
                return Mono.just(exists);
            });
    }

    private Mono<LicenceType> sendCommandAndQueryResult(BaseCommand command) {
        var query = GetLicenceTypeQuery.builder().aggregateId(command.getAggregateId()).build();

        var subscriptionQuery = queryGateway.subscriptionQuery(
            query,
            ResponseTypes.multipleInstancesOf(LicenceType.class),
            ResponseTypes.instanceOf(LicenceType.class));

        return Mono.fromFuture(commandGateway.send(command))
            .then(subscriptionQuery.updates().next().doFinally(s -> subscriptionQuery.close()));
    }

}
