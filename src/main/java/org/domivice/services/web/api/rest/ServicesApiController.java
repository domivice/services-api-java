package org.domivice.services.web.api.rest;

import org.domivice.services.web.api.rest.models.Amenity;
import org.domivice.services.web.api.rest.models.AmenityCreate;
import org.domivice.services.web.api.rest.models.AmenityPatch;
import org.domivice.services.web.api.rest.models.BlockedDate;
import org.domivice.services.web.api.rest.models.BlockedDateCreate;
import org.domivice.services.web.api.rest.models.BlockedDatePatch;
import org.domivice.services.web.api.rest.models.Certification;
import org.domivice.services.web.api.rest.models.CertificationCreate;
import org.domivice.services.web.api.rest.models.CertificationPatch;
import org.domivice.services.web.api.rest.models.Document;
import org.domivice.services.web.api.rest.models.DocumentCreate;
import org.domivice.services.web.api.rest.models.DocumentList;
import org.domivice.services.web.api.rest.models.DocumentRequirement;
import org.domivice.services.web.api.rest.models.DocumentRequirementCreate;
import org.domivice.services.web.api.rest.models.DocumentRequirementList;
import org.domivice.services.web.api.rest.models.DocumentRequirementPatch;
import org.domivice.services.web.api.rest.models.DocumentType;
import org.domivice.services.web.api.rest.models.DocumentTypeCreate;
import org.domivice.services.web.api.rest.models.DocumentTypeList;
import org.domivice.services.web.api.rest.models.DocumentTypePatch;
import org.domivice.services.web.api.rest.models.Error;
import org.domivice.services.web.api.rest.models.Licence;
import org.domivice.services.web.api.rest.models.LicenceCreate;
import org.domivice.services.web.api.rest.models.LicenceIssuer;
import org.domivice.services.web.api.rest.models.LicenceIssuerCreate;
import org.domivice.services.web.api.rest.models.LicenceIssuerList;
import org.domivice.services.web.api.rest.models.LicenceIssuerPatch;
import org.domivice.services.web.api.rest.models.LicenceList;
import org.domivice.services.web.api.rest.models.LicencePatch;
import org.domivice.services.web.api.rest.models.LicenceRequirement;
import org.domivice.services.web.api.rest.models.LicenceRequirementCreate;
import org.domivice.services.web.api.rest.models.LicenceRequirementList;
import org.domivice.services.web.api.rest.models.LicenceRequirementPatch;
import org.domivice.services.web.api.rest.models.LicenceType;
import org.domivice.services.web.api.rest.models.LicenceTypeCreate;
import org.domivice.services.web.api.rest.models.LicenceTypeList;
import org.domivice.services.web.api.rest.models.LicenceTypePatch;
import org.domivice.services.web.api.rest.models.Media;
import org.domivice.services.web.api.rest.models.ReviewList;
import org.domivice.services.web.api.rest.models.Service;
import org.domivice.services.web.api.rest.models.ServiceCategory;
import org.domivice.services.web.api.rest.models.ServiceCategoryCreate;
import org.domivice.services.web.api.rest.models.ServiceCategoryList;
import org.domivice.services.web.api.rest.models.ServiceCategoryPatch;
import org.domivice.services.web.api.rest.models.ServiceCreate;
import org.domivice.services.web.api.rest.models.ServiceList;
import org.domivice.services.web.api.rest.models.ServiceOffering;
import org.domivice.services.web.api.rest.models.ServiceOfferingCreate;
import org.domivice.services.web.api.rest.models.ServiceOfferingPatch;
import org.domivice.services.web.api.rest.models.ServicePatch;
import org.domivice.services.web.api.rest.models.ServiceProvider;
import org.domivice.services.web.api.rest.models.ServiceProviderList;
import org.domivice.services.web.api.rest.models.ServiceProviderPatch;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
@Controller
@RequestMapping("${openapi.Domivice Services Rest Api.base-path:}")
public class ServicesApiController implements ServicesApi {

    private final NativeWebRequest request;

    @Autowired
    public ServicesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
