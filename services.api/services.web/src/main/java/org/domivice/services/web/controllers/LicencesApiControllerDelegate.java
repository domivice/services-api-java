package org.domivice.services.web.controllers;

import lombok.RequiredArgsConstructor;
import org.domivice.services.application.licences.LicenceTypeCommandService;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.openapi.controllers.LicencesApi;
import org.domivice.services.openapi.controllers.LicencesApiDelegate;
import org.domivice.services.openapi.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicencesApiControllerDelegate implements LicencesApiDelegate {

    private final ModelMapper modelMapper;
    private final LicenceTypeCommandService commandService;

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
                        .id(UUID.randomUUID())
                        .name(l.getName())
                        .build())
                .flatMap(commandService::addLicenceType)
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
    public Mono<ResponseEntity<LicenceIssuer>> addLicenceTypeIssuer(Mono<LicenceIssuerCreate> licenceIssuerCreate, ServerWebExchange exchange) {
        return LicencesApiDelegate.super.addLicenceTypeIssuer(licenceIssuerCreate, exchange);
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
        return LicencesApiDelegate.super.deleteLicenceIssuer(licenceIssuerId, exchange);
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
        return LicencesApiDelegate.super.deleteLicenceType(licenceTypeId, exchange);
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
    public Mono<ResponseEntity<LicenceType>> getLicenceType(UUID licenceTypeId, ServerWebExchange exchange) {
        return LicencesApiDelegate.super.getLicenceType(licenceTypeId, exchange);
    }

    /**
     * GET /services/v1/licence-issuers : List Licence Issuers
     *
     * @param search        The search term (optional)
     * @param countryCode   Filter licence issuer by country code (optional)
     * @param stateCode     Filter licence issuers by state code (optional)
     * @param licenceTypeId Filter licence type by licence type (optional)
     * @param exchange
     * @return Response when 0 or more licence types are returned  (status code 200)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * @see LicencesApi#listLicenceIssuers
     */
    @Override
    public Mono<ResponseEntity<LicenceIssuerList>> listLicenceIssuers(String search, String countryCode, String stateCode, String licenceTypeId, ServerWebExchange exchange) {
        return LicencesApiDelegate.super.listLicenceIssuers(search, countryCode, stateCode, licenceTypeId, exchange);
    }

    /**
     * GET /services/v1/licence-types : List Licence Types
     *
     * @param search   The licence type search term (optional)
     * @param exchange
     * @return Response when 0 or more licence types are returned (status code 200)
     * or User is not authenticated (status code 401)
     * or User is not allowed to perform action (status code 403)
     * @see LicencesApi#listLicenceTypes
     */
    @Override
    public Mono<ResponseEntity<LicenceTypeList>> listLicenceTypes(String search, ServerWebExchange exchange) {
        return LicencesApiDelegate.super.listLicenceTypes(search, exchange);
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
    public Mono<ResponseEntity<LicenceIssuer>> updateLicenceIssuer(UUID licenceIssuerId, Mono<LicenceIssuerPatch> licenceIssuerPatch, ServerWebExchange exchange) {
        return LicencesApiDelegate.super.updateLicenceIssuer(licenceIssuerId, licenceIssuerPatch, exchange);
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
    public Mono<ResponseEntity<LicenceType>> updateLicenceType(UUID licenceTypeId, Mono<LicenceTypePatch> licenceTypePatch, ServerWebExchange exchange) {
        return LicencesApiDelegate.super.updateLicenceType(licenceTypeId, licenceTypePatch, exchange);
    }
}
