package org.domivice.services.web.configurations;


import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.proc.DefaultJOSEObjectTypeVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.springframework.security.oauth2.core.authorization.OAuth2ReactiveAuthorizationManagers.hasScope;

@EnableWebFluxSecurity
@Configuration
@EnableReactiveMethodSecurity
public class SecurityConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    String jwkSetUri;
    @Value("${spring.security.oauth2.resourceserver.jwt.audiences}")
    String audiences;

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(ServerHttpSecurity.CorsSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/services/**").access(hasScope(audiences))
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(
                        oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(grantedAuthoritiesExtractor(audiences)))
                );
        return http.build();
    }

    @Bean
    public ReactiveJwtDecoder reactiveJwtDecoder() {
        return NimbusReactiveJwtDecoder
                .withJwkSetUri(jwkSetUri)
                .jwtProcessorCustomizer(jwtProcessor -> jwtProcessor.setJWSTypeVerifier(new DefaultJOSEObjectTypeVerifier<>(new JOSEObjectType("at+jwt"))))
                .build();
    }

    Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthoritiesExtractor(String audiences) {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new GrantedAuthoritiesExtractor(audiences));

        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }
}

class GrantedAuthoritiesExtractor implements Converter<Jwt, Collection<GrantedAuthority>> {
    private String audiences;

    public GrantedAuthoritiesExtractor(String audiences) {
        this.audiences = audiences;
    }

    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        Collection<?> scopes = (Collection<?>) jwt.getClaims().getOrDefault("scope", Collections.emptyList());
        if (scopes.stream().anyMatch(s -> s.toString().equals(this.audiences))) {
            authorities.add(new SimpleGrantedAuthority("SCOPE_" + this.audiences));
        }

        var singleRole = jwt.getClaims().getOrDefault("role", "").toString();
        if (!singleRole.isEmpty()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + singleRole));
        }

        Collection<?> rolesCollection = (Collection<?>) jwt.getClaims().getOrDefault("roles", Collections.emptyList());
        for (Object role : rolesCollection) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }

        return authorities;
    }
}