package org.domivice.services.application.tests.licences;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.domivice.services.application.licences.LicenceTypeAggregate;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licences.events.LicenceTypeCreatedEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class LicenceTypeAggregateTests {
    private static final String LicenceTypeName = "New Licence Type";
    FixtureConfiguration<LicenceTypeAggregate> fixture;
    private UUID id;

    @BeforeEach
    public void setUp() {
        fixture = new AggregateTestFixture<>(LicenceTypeAggregate.class);
        id = UUID.randomUUID();
    }

    @Test
    @DisplayName("Create Licence Type Command Should Dispatch Created Licence Type Event")
    void should_dispatch_licence_type_created_event_when_create_licence_type_command() {
        fixture.givenNoPriorActivity()
                .when(CreateLicenceTypeCommand.builder()
                        .id(id)
                        .name(LicenceTypeName)
                        .build()
                )
                .expectEvents(LicenceTypeCreatedEvent.builder()
                        .id(id)
                        .name(LicenceTypeName)
                        .build()
                );
    }
}
