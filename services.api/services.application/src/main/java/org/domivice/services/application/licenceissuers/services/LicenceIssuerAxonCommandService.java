package org.domivice.services.application.licenceissuers.services;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.domivice.services.application.licenceissuers.commands.CreateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerQuery;
import org.domivice.services.application.licences.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.domivice.services.domain.exceptions.ValidationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenceIssuerAxonCommandService implements LicenceIssuerCommandService {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
    private final LicenceTypeRepository licenceTypeRepository;

    @Override
    public Mono<LicenceIssuer> addLicenceIssuer(CreateLicenceIssuerCommand command) {
        return validateLicenceTypeId(command.getLicenceTypeId())
            .then(sendCommandAndQueryResult(command));
    }

    private Mono<Void> validateLicenceTypeId(UUID licenceTypeId) {
        return licenceTypeRepository.existsById(licenceTypeId)
            .flatMap(exists -> {
                if (exists.equals(Boolean.FALSE)) {
                    return Mono.error(new ValidationException(
                        Map.of("licenceTypeId", List.of("Licence type with id " + licenceTypeId + " not found"))));
                }
                return Mono.empty();
            });
    }

    private Mono<LicenceIssuer> sendCommandAndQueryResult(CreateLicenceIssuerCommand command) {
        var query = GetLicenceIssuerQuery.builder().id(command.getId()).build();
        var subscriptionQuery = subscriptionQuery(query);
        return Mono.fromFuture(commandGateway.send(command))
            .then(subscriptionQuery.updates().next().doFinally(s -> subscriptionQuery.close()));
    }

    private SubscriptionQueryResult<List<LicenceIssuer>, LicenceIssuer> subscriptionQuery(GetLicenceIssuerQuery query) {
        return queryGateway.subscriptionQuery(
            query,
            ResponseTypes.multipleInstancesOf(LicenceIssuer.class),
            ResponseTypes.instanceOf(LicenceIssuer.class));
    }
}
