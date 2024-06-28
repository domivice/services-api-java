package org.domivice.services.application.licenceissuers.services;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.domivice.services.application.common.commands.BaseCommand;
import org.domivice.services.application.common.services.RegionValidator;
import org.domivice.services.application.licenceissuers.LicenceIssuerRepository;
import org.domivice.services.application.licenceissuers.commands.CreateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.commands.DeleteLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.commands.UpdateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerQuery;
import org.domivice.services.application.licencetypes.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.domivice.services.domain.exceptions.NotFoundException;
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
    private final LicenceIssuerRepository licenceIssuerRepository;
    private final RegionValidator regionValidator;

    @Override
    public Mono<LicenceIssuer> addLicenceIssuer(CreateLicenceIssuerCommand command) {
        return checkIfCountryCodeIsValid(command.getIssuingCountryCode(), true)
            .then(checkIfStateCodeIsValid(command.getIssuingStateCode(), command.getIssuingCountryCode(), true))
            .then(checkIfLicenceTypeIdIsValid(command.getLicenceTypeId(), true))
            .then(sendCommandAndQueryResult(command));
    }

    @Override
    public Mono<LicenceIssuer> updateLicenceIssuer(UpdateLicenceIssuerCommand command) {
        return checkIfCountryCodeIsValid(command.getIssuingCountryCode(), false)
            .then(checkIfStateCodeIsValid(command.getIssuingStateCode(), command.getIssuingCountryCode(), false))
            .then(checkIfLicenceIssuerExists(command.getAggregateId()))
            .then(checkIfLicenceTypeIdIsValid(command.getLicenceTypeId(), false))
            .then(sendCommandAndQueryResult(command));
    }

    @Override
    public Mono<Void> deleteLicenceIssuer(DeleteLicenceIssuerCommand command) {
        return checkIfLicenceIssuerExists(command.getAggregateId())
            .then(Mono.fromFuture(commandGateway.send(command)));
    }

    private Mono<Void> checkIfLicenceTypeIdIsValid(UUID licenceTypeId, Boolean required) {
        if (licenceTypeId == null) {
            return required.equals(Boolean.TRUE)
                ? Mono.error(new ValidationException(Map.of("licenceTypeId", List.of("Licence type id is required"))))
                : Mono.empty();
        }

        return licenceTypeRepository.existsById(licenceTypeId)
            .flatMap(exists -> {
                if (exists.equals(Boolean.FALSE)) {
                    return Mono.error(new ValidationException(
                        Map.of("licenceTypeId", List.of("Licence type with id " + licenceTypeId + " not found"))));
                }
                return Mono.empty();
            });
    }

    private Mono<Void> checkIfLicenceIssuerExists(UUID licenceIssuerId) {
        return licenceIssuerRepository.existsById(licenceIssuerId).flatMap(exists -> {
            if (exists.equals(Boolean.FALSE)) {
                return Mono.error(new NotFoundException("Licence issuer with id " + licenceIssuerId + " not found"));
            }
            return Mono.empty();
        });
    }

    private Mono<Void> checkIfCountryCodeIsValid(String countryCode, Boolean required) {
        if (countryCode == null) {
            return required.equals(Boolean.TRUE)
                ? Mono.error(new ValidationException(Map.of("issuingCountryCode", List.of("Country code is required"))))
                : Mono.empty();
        }
        if (!regionValidator.isCountrySupported(countryCode)) {
            return Mono.error(new ValidationException(Map.of("issuingCountryCode", List.of("Country code is not supported"))));
        }
        return Mono.empty();
    }

    private Mono<Void> checkIfStateCodeIsValid(String stateCode, String countryCode, Boolean required) {
        if (stateCode == null) {
            return required.equals(Boolean.TRUE)
                ? Mono.error(new ValidationException(Map.of("issuingStateCode", List.of("State code is required"))))
                : Mono.empty();
        }
        if (!regionValidator.isStateSupported(countryCode, stateCode)) {
            return Mono.error(new ValidationException(Map.of("issuingStateCode", List.of("State code is not supported"))));
        }
        return Mono.empty();
    }

    private Mono<LicenceIssuer> sendCommandAndQueryResult(BaseCommand command) {
        var query = GetLicenceIssuerQuery.builder().aggregateId(command.getAggregateId()).build();

        var subscriptionQuery = queryGateway.subscriptionQuery(
            query,
            ResponseTypes.multipleInstancesOf(LicenceIssuer.class),
            ResponseTypes.instanceOf(LicenceIssuer.class)
        );

        return Mono.fromFuture(commandGateway.send(command))
            .then(subscriptionQuery.updates().next().doFinally(s -> subscriptionQuery.close()));
    }
}
