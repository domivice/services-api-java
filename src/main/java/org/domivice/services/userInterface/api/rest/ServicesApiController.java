package org.domivice.services.userInterface.api.rest;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
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
