package org.domivice.services.domain.exceptions;

public class LicenceTypeNotFoundException extends RuntimeException {
    public LicenceTypeNotFoundException(String message) {
        super(message);
    }

    public LicenceTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
