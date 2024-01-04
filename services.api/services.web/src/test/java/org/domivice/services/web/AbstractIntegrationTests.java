package org.domivice.services.web;

import org.domivice.services.web.configurations.ModelMapperConfiguration;
import org.domivice.services.web.controllers.LicencesApiControllerDelegate;
import org.domivice.services.web.exceptions.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@AutoConfigureWebTestClient
@Import({LicencesApiControllerDelegate.class, ContainerConfiguration.class, ModelMapperConfiguration.class, GlobalExceptionHandler.class})
@EnableAutoConfiguration
public abstract class AbstractIntegrationTests {
}
