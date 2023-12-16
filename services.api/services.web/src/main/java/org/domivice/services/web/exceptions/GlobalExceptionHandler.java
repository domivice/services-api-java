package org.domivice.services.web.exceptions;

import org.domivice.services.openapi.models.ProblemDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = WebExchangeBindException.class)
    public Mono<ResponseEntity<ProblemDetail>> exception(WebExchangeBindException exception, ServerWebExchange exchange) {
        ProblemDetail problemDetail = new ProblemDetail()
                .status(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .instance(exchange.getRequest().getPath().toString())
                .type("https://domivice.com/services/probs/validation-error")
                .title("A validation error occurred")
                .detail("One or more fields are invalid");
        Map<String, List<String>> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, t -> List.of(Objects.requireNonNull(t.getDefaultMessage()))));
        problemDetail.setErrors(errors);

        return Mono.just(new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(value = Throwable.class)
    public Mono<ResponseEntity<ProblemDetail>> exception() {
        return Mono.just(new ResponseEntity<>(new ProblemDetail(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(value = ServerWebInputException.class)
    public Mono<ResponseEntity<ProblemDetail>> exception(ServerWebExchange exchange){
        ProblemDetail problemDetail = new ProblemDetail()
                .status(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .instance(exchange.getRequest().getPath().toString())
                .type("https://domivice.com/services/probs/request-format")
                .title("Request formatting problem")
                .detail("The request body is malformed");
        return Mono.just(new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST));
    }
}