package org.domivice.services.web.test.api.licences;

import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.domivice.domain.entities.LicenceType;
import org.domivice.services.application.licences.LicenceTypeCommandService;
import org.domivice.services.application.licences.LicenceTypeRepository;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.openapi.models.LicenceTypeCreate;
import org.domivice.services.web.controllers.LicencesApiControllerDelegate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;

@WebFluxTest(LicencesApiControllerDelegate.class)
public class AddLicenceTypeTests {
    private final String ENDPOINT = "/services/v1/licence-types";
    @Autowired
    private WebTestClient webClient;
    @MockBean
    private ModelMapper modelMapper;
    @MockBean
    private LicenceTypeCommandService commandService;
    @MockBean
    private LicenceTypeRepository repository;
    @MockBean
    private QueryUpdateEmitter queryUpdateEmitter;

    @DisplayName("Should return Problem Details When Name is Empty")
    @Test
    public void shouldReturnProblemDetailWhenNameIsEmpty() {
        LicenceTypeCreate licenceTypeCreate = new LicenceTypeCreate();
        webClient
                .post()
                .uri(ENDPOINT)
                .bodyValue(licenceTypeCreate)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody().jsonPath("$.errors").isNotEmpty();
    }

    @Test
    public void shouldReturnStatusCreated() {
        LicenceTypeCreate licenceTypeCreate = new LicenceTypeCreate().name("New Licence");
        LicenceType licenceType = LicenceType.builder().name(licenceTypeCreate.getName()).build();
        Mockito.when(commandService.addLicenceType(any(CreateLicenceTypeCommand.class)))
                .thenReturn(Mono.just(licenceType));
        Mockito.when(modelMapper.map(any(LicenceType.class), any()))
                .thenReturn(new org.domivice.services.openapi.models.LicenceType().name(licenceType.getName()));
        webClient
                .post()
                .uri(ENDPOINT)
                .bodyValue(licenceTypeCreate)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(org.domivice.services.openapi.models.LicenceType.class);
    }
}
