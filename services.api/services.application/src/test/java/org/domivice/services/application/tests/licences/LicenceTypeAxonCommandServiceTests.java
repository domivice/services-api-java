package org.domivice.services.application.tests.licences;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.InstanceResponseType;
import org.axonframework.messaging.responsetypes.MultipleInstancesResponseType;
import org.axonframework.queryhandling.DefaultSubscriptionQueryResult;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.domivice.domain.entities.LicenceType;
import org.domivice.services.application.licences.LicenceTypeAxonCommandService;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licences.queries.GetLicenceTypeQuery;
import org.junit.jupiter.api.Assertions;
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
public class LicenceTypeAxonCommandServiceTests {
    @MockBean
    private CommandGateway commandGateway;
    @MockBean
    private QueryGateway queryGateway;
    @MockBean
    SubscriptionQueryResult<List<LicenceType>, LicenceType> subscriptionQuery;
    @Autowired
    private LicenceTypeAxonCommandService commandService;

    @Test
    public void addLicenceType_should_return_added_LicenceType() {
        var command = CreateLicenceTypeCommand.builder()
                .id(UUID.randomUUID())
                .name("New Licence")
                .build();
        var licenceType = LicenceType.builder()
                .id(UUID.randomUUID())
                .name(command.getName())
                .build();
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
