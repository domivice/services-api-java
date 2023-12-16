package org.domivice.services.application.licences;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.domivice.domain.entities.LicenceType;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licences.queries.GetLicenceTypeQuery;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenceTypeCommandServiceImpl implements LicenceTypeCommandService {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Override
    public Mono<LicenceType> addLicenceType(CreateLicenceTypeCommand command) {
        GetLicenceTypeQuery query = GetLicenceTypeQuery
                .builder()
                .id(command.getId())
                .build();
        SubscriptionQueryResult<List<LicenceType>, LicenceType> subscriptionQuery = this.subscriptionQuery(query);

        return commandGateway
                .send(command)
                .thenApply(e -> subscriptionQuery.updates().next())
                .join();
    }

    private SubscriptionQueryResult<List<LicenceType>, LicenceType> subscriptionQuery(GetLicenceTypeQuery query) {
        return queryGateway.subscriptionQuery(
                query,
                ResponseTypes.multipleInstancesOf(LicenceType.class),
                ResponseTypes.instanceOf(LicenceType.class));
    }
}
