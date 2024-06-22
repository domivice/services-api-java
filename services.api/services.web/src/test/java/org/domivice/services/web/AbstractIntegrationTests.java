package org.domivice.services.web;


import org.domivice.services.domain.configurations.ModelMapperConfiguration;
import org.domivice.services.web.controllers.LicencesApiControllerDelegate;
import org.domivice.services.web.exceptions.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Supplier;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

@SpringBootTest
@AutoConfigureWebTestClient
@Import({
    LicencesApiControllerDelegate.class,
    ContainerConfiguration.class,
    ModelMapperConfiguration.class,
    GlobalExceptionHandler.class
})
@EnableAutoConfiguration
public abstract class AbstractIntegrationTests {
    protected final String AUDIENCE = "services.api";
    protected final String ADMIN_ROLE = "AppAdmin";
    protected final String TOKEN_TYPE = "at+jwt";
    protected final SecurityMockServerConfigurers.JwtMutator authorizedJwtMutator = mockJwt().jwt(
        jwt -> jwt.header("typ", TOKEN_TYPE)).authorities(
        new SimpleGrantedAuthority("ROLE_" + ADMIN_ROLE),
        new SimpleGrantedAuthority("SCOPE_" + AUDIENCE)
    );

    protected void RepeatedStepVerifier(Supplier<Mono<Boolean>> monoSupplier, int maxRetries, Duration delay) {
        Mono<Boolean> verified = Mono.defer(monoSupplier)
            .flatMap(exists -> Mono.just(!exists)) // True if deleted, False otherwise
            .repeatWhenEmpty(maxRetries, flux -> flux.delayElements(delay)); // Retry with delay

        StepVerifier.create(verified)
            .expectNext(true)
            .verifyComplete();
    }
}
