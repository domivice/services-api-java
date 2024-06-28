package org.domivice.services.web.controllers;

import lombok.RequiredArgsConstructor;
import org.domivice.services.application.licenceissuers.commands.CreateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.commands.DeleteLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.commands.UpdateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.services.LicenceIssuerCommandService;
import org.domivice.services.application.licenceissuers.services.LicenceIssuerQueryService;
import org.domivice.services.application.licencetypes.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.commands.DeleteLicenceTypeCommand;
import org.domivice.services.application.licencetypes.commands.UpdateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypeQuery;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypesByNameQuery;
import org.domivice.services.application.licencetypes.services.LicenceTypeCommandService;
import org.domivice.services.application.licencetypes.services.LicenceTypeQueryService;
import org.domivice.services.openapi.controllers.LicencesApi;
import org.domivice.services.openapi.controllers.LicencesApiDelegate;
import org.domivice.services.openapi.models.*;
import org.domivice.services.web.constants.PaginationConstants;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicencesApiControllerDelegate implements LicencesApiDelegate {

    private final ModelMapper modelMapper;
    private final LicenceTypeCommandService licenceTypeCommandService;
    private final LicenceTypeQueryService licenceTypeQueryService;
    private final LicenceIssuerCommandService licenceIssuerCommandService;
    private final LicenceIssuerQueryService licenceIssuerQueryService;

    /**
     * POST /services/v1/licence-types : Add Licence Type-
     *
     * @param licenceTypeCreate (required)
     * @param exchange
     * @return Response when licence type is created (status code 201)
     * or There was an error with the request (status code 400)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * @see LicencesApi#addLicenceType
     */
    @Override
    @PreAuthorize("hasRole('AppAdmin')")
    public Mono<ResponseEntity<LicenceType>> addLicenceType(Mono<LicenceTypeCreate> licenceTypeCreate, ServerWebExchange exchange) {
        return licenceTypeCreate
            .map(l -> CreateLicenceTypeCommand
                .builder()
                .commandId(UUID.randomUUID())
                .aggregateId(UUID.randomUUID())
                .name(l.getName())
                .build())
            .flatMap(licenceTypeCommandService::addLicenceType)
            .map(l -> modelMapper.map(l, LicenceType.class))
            .map(l -> ResponseEntity.status(HttpStatus.CREATED).body(l));
    }

    /**
     * POST /services/v1/licence-issuers : Add Licence Type Issuer
     *
     * @param licenceIssuerCreate (required)
     * @param exchange
     * @return Response when licence type is created (status code 201)
     * or There was an error with the request (status code 400)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * @see LicencesApi#addLicenceTypeIssuer
     */
    @Override
    @PreAuthorize("hasRole('AppAdmin')")
    public Mono<ResponseEntity<LicenceIssuer>> addLicenceTypeIssuer(Mono<LicenceIssuerCreate> licenceIssuerCreate, ServerWebExchange exchange) {
        return licenceIssuerCreate
            .map(payload -> CreateLicenceIssuerCommand.builder()
                .aggregateId(UUID.randomUUID())
                .issuerName(payload.getIssuerName())
                .issuingCountryCode(payload.getIssuingCountryCode())
                .issuingStateCode(payload.getIssuingStateCode())
                .licenceTypeId(payload.getLicenceTypeId())
                .build())
            .flatMap(licenceIssuerCommandService::addLicenceIssuer)
            .map(entity -> modelMapper.map(entity, LicenceIssuer.class))
            .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response));
    }

    /**
     * DELETE /services/v1/licence-issuers/{licenceIssuerId} : Delete Licence Issuer
     *
     * @param licenceIssuerId Licence issuer id (required)
     * @param exchange
     * @return Response when licence issuer is deleted (status code 204)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * or The resource was not found (status code 404)
     * @see LicencesApi#deleteLicenceIssuer
     */
    @Override
    public Mono<ResponseEntity<Void>> deleteLicenceIssuer(UUID licenceIssuerId, ServerWebExchange exchange) {
        return Mono.just(DeleteLicenceIssuerCommand.builder()
                .aggregateId(licenceIssuerId)
                .build()).flatMap(licenceIssuerCommandService::deleteLicenceIssuer)
            .then(Mono.just(ResponseEntity.noContent().build()));
    }

    /**
     * DELETE /services/v1/licence-types/{licenceTypeId} : Delete Licence Type
     *
     * @param licenceTypeId Licence Type id (required)
     * @param exchange
     * @return Response when the licence type is deleted (status code 204)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * or The resource was not found (status code 404)
     * @see LicencesApi#deleteLicenceType
     */
    @Override
    public Mono<ResponseEntity<Void>> deleteLicenceType(UUID licenceTypeId, ServerWebExchange exchange) {
        return Mono.just(DeleteLicenceTypeCommand.builder()
                .commandId(UUID.randomUUID())
                .aggregateId(licenceTypeId)
                .build())
            .flatMap(licenceTypeCommandService::deleteLicenceType)
            .then(Mono.just(ResponseEntity.noContent().build()));
    }

    /**
     * GET /services/v1/licence-issuers/{licenceIssuerId} : Get Licence Issuer
     *
     * @param licenceIssuerId Licence issuer id (required)
     * @param exchange
     * @return Response when licence issuer is returned (status code 200)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * or The resource was not found (status code 404)
     * @see LicencesApi#getLicenceIssuer
     */
    @Override
    public Mono<ResponseEntity<LicenceIssuer>> getLicenceIssuer(UUID licenceIssuerId, ServerWebExchange exchange) {
        return LicencesApiDelegate.super.getLicenceIssuer(licenceIssuerId, exchange);
    }

    /**
     * GET /services/v1/licence-types/{licenceTypeId} : Get Licence Type
     *
     * @param licenceTypeId Licence Type id (required)
     * @param exchange
     * @return Response when licence type is returned (status code 200)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * or The resource was not found (status code 404)
     * @see LicencesApi#getLicenceType
     */
    @Override
    @PreAuthorize("hasRole('AppAdmin')")
    public Mono<ResponseEntity<LicenceType>> getLicenceType(UUID licenceTypeId, ServerWebExchange exchange) {
        return Mono.just(GetLicenceTypeQuery
                .builder()
                .licenceTypeId(licenceTypeId)
                .build())
            .flatMap(licenceTypeQueryService::getLicenceType)
            .map(l -> modelMapper.map(l, LicenceType.class))
            .map(l -> ResponseEntity.status(HttpStatus.OK).body(l))
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Licence type not found")));
    }

    /**
     * GET /services/v1/licence-issuers : List Licence Issuers
     *
     * @param search        The search term (optional)
     * @param countryCode   Filter licence issuer by country code (optional)
     * @param stateCode     Filter licence issuers by state code (optional)
     * @param licenceTypeId Filter licence type by licence type (optional)
     * @param page          The page requested. Page parameter can only be a positive integer greater than 0. (optional)
     * @param pageSize      The requested page size. Page size can only be between 1 and 100 (optional)
     * @param sort          The result sorting. field1[:asc|desc][,field2[:asc|desc]] e.g. firstName:desc,email:asc (optional)
     * @param exchange
     * @return Response when 0 or more licence types are returned  (status code 200)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * @see LicencesApi#listLicenceIssuers
     */
    @Override
    public Mono<ResponseEntity<LicenceIssuerList>> listLicenceIssuers(String search, String countryCode, String stateCode, String licenceTypeId, Integer page, Integer pageSize, String sort, ServerWebExchange exchange) {
        return LicencesApiDelegate.super.listLicenceIssuers(search, countryCode, stateCode, licenceTypeId, page, pageSize, sort, exchange);
    }

    /**
     * GET /services/v1/licence-types : List Licence Types
     *
     * @param search   The licence type search term (optional)
     * @param page     The page requested. Page parameter can only be a positive integer greater than 0. (optional)
     * @param pageSize The requested page size. Page size can only be between 1 and 100 (optional)
     * @param sort     The result sorting. field1[:asc|desc][,field2[:asc|desc]] e.g. firstName:desc,email:asc (optional)
     * @param exchange
     * @return Response when 0 or more licence types are returned (status code 200)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * @see LicencesApi#listLicenceTypes
     */
    @Override
    @PreAuthorize("hasRole('AppAdmin')")
    public Mono<ResponseEntity<LicenceTypeList>> listLicenceTypes(String search, Integer page, Integer pageSize, String sort, ServerWebExchange exchange) {
        int finalPage = page != null ? page : PaginationConstants.DEFAULT_PAGE;
        int finalPageSize = pageSize != null ? pageSize : PaginationConstants.DEFAULT_PAGE_SIZE;

        return Mono.just(GetLicenceTypesByNameQuery.builder()
                .name(search)
                .page(finalPage)
                .pageSize(finalPageSize)
                .sort(sort != null ? sort : "name:asc")
                .build())
            .flatMapMany(licenceTypeQueryService::getLicenceTypesByName)
            .map(entity -> modelMapper.map(entity, LicenceType.class)) // map to LicenceType
            .collectList()
            .map(licenceTypes -> ResponseEntity.status(HttpStatus.OK).body(
                new LicenceTypeList()
                    .data(licenceTypes)
                    .pageCount(BigDecimal.valueOf(finalPage))
                    .totalItemsCount(BigDecimal.valueOf(licenceTypes.size()))
            ));
    }

    /**
     * PATCH /services/v1/licence-issuers/{licenceIssuerId} : Update Licence Issuer
     *
     * @param licenceIssuerId    Licence issuer id (required)
     * @param licenceIssuerPatch (required)
     * @param exchange
     * @return Response when the licence issuer is updated (status code 200)
     * or There was an error with the request (status code 400)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * or The resource was not found (status code 404)
     * @see LicencesApi#updateLicenceIssuer
     */
    @Override
    @PreAuthorize("hasRole('AppAdmin')")
    public Mono<ResponseEntity<LicenceIssuer>> updateLicenceIssuer(UUID licenceIssuerId, Mono<LicenceIssuerPatch> licenceIssuerPatch, ServerWebExchange exchange) {
        return licenceIssuerPatch.map(payload -> UpdateLicenceIssuerCommand.builder()
                .aggregateId(licenceIssuerId)
                .licenceTypeId(payload.getLicenceTypeId())
                .issuingCountryCode(payload.getIssuingCountryCode())
                .issuingStateCode(payload.getIssuingStateCode())
                .issuerName(payload.getIssuerName())
                .build()
            ).flatMap(licenceIssuerCommandService::updateLicenceIssuer)
            .map(entity -> modelMapper.map(entity, LicenceIssuer.class))
            .map(response -> ResponseEntity.status(HttpStatus.OK).body(response));
    }

    /**
     * PATCH /services/v1/licence-types/{licenceTypeId} : Update Licence Type
     *
     * @param licenceTypeId    Licence Type id (required)
     * @param licenceTypePatch (required)
     * @param exchange
     * @return Response when licence type is updated (status code 200)
     * or There was an error with the request (status code 400)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * or The resource was not found (status code 404)
     * @see LicencesApi#updateLicenceType
     */
    @Override
    @PreAuthorize("hasRole('AppAdmin')")
    public Mono<ResponseEntity<LicenceType>> updateLicenceType(UUID licenceTypeId, Mono<LicenceTypePatch> licenceTypePatch, ServerWebExchange exchange) {
        return licenceTypePatch.map(payload -> UpdateLicenceTypeCommand.builder()
                .aggregateId(licenceTypeId)
                .commandId(UUID.randomUUID())
                .name(payload.getName())
                .build()
            ).flatMap(licenceTypeCommandService::updateLicenceType)
            .map(entity -> modelMapper.map(entity, LicenceType.class))
            .map(response -> ResponseEntity.status(HttpStatus.OK).body(response));
    }
}
