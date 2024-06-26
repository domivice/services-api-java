package org.domivice.services.application.tests.licences;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.InstanceResponseType;
import org.axonframework.messaging.responsetypes.MultipleInstancesResponseType;
import org.axonframework.queryhandling.DefaultSubscriptionQueryResult;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.domivice.services.application.licencetypes.LicenceTypeRepository;
import org.domivice.services.application.licencetypes.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypeQuery;
import org.domivice.services.application.licencetypes.services.LicenceTypeAxonCommandService;
import org.domivice.services.domain.entities.LicenceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = LicenceTypeAxonCommandService.class)
@ExtendWith(MockitoExtension.class)
class LicenceTypeAxonCommandServiceTests {
    @MockBean
    SubscriptionQueryResult<List<LicenceType>, LicenceType> subscriptionQuery;
    @MockBean
    private CommandGateway commandGateway;
    @MockBean
    private QueryGateway queryGateway;
    @MockBean
    private LicenceTypeRepository licenceTypeRepository;
    @Autowired
    private LicenceTypeAxonCommandService commandService;

    @Test
    @DisplayName("Add Licence Type Should Return Added Licence Type")
    void addLicenceTypeShouldReturnAddedLicenceType() {
        var command = CreateLicenceTypeCommand.builder()
            .commandId(UUID.randomUUID())
            .aggregateId(UUID.randomUUID())
            .name("New Licence")
            .build();
        var licenceType = LicenceType.create(command.getAggregateId(), command.getName());
        var subscriptionQuery = new DefaultSubscriptionQueryResult<>(
            Mono.just(List.of(licenceType)),
            Flux.just(licenceType),
            () -> true
        );

        Mockito.doReturn(CompletableFuture.supplyAsync(() -> Mono.just(licenceType)))
            .when(commandGateway)
            .send(any(CreateLicenceTypeCommand.class));
        Mockito.doReturn(subscriptionQuery)
            .when(queryGateway)
            .subscriptionQuery(any(GetLicenceTypeQuery.class),
                ArgumentMatchers.<MultipleInstancesResponseType<LicenceType>>any(),
                ArgumentMatchers.<InstanceResponseType<LicenceType>>any());

        commandService.addLicenceType(command)
            .switchIfEmpty(Mono.defer(Assertions::fail))
            .subscribe(e -> Assertions.assertEquals(e, licenceType));
    }
}
