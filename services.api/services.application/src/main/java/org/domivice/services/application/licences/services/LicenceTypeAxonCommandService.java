package org.domivice.services.application.licences.services;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licences.queries.GetLicenceTypeQuery;
import org.domivice.services.domain.entities.LicenceType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenceTypeAxonCommandService implements LicenceTypeCommandService {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Override
    public Mono<LicenceType> addLicenceType(CreateLicenceTypeCommand command) {
        var query = GetLicenceTypeQuery
            .builder()
            .id(command.getId())
            .build();
        var subscriptionQuery = this.subscriptionQuery(query);
        return Mono.fromFuture(commandGateway.send(command))
            .flatMap(e -> subscriptionQuery.updates().next().doFinally(s -> subscriptionQuery.close()));
    }

    private SubscriptionQueryResult<List<LicenceType>, LicenceType> subscriptionQuery(GetLicenceTypeQuery query) {
        return queryGateway.subscriptionQuery(
            query,
            ResponseTypes.multipleInstancesOf(LicenceType.class),
            ResponseTypes.instanceOf(LicenceType.class));
    }
}
