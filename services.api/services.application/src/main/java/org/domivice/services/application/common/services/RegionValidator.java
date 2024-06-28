package org.domivice.services.application.common.services;

public interface RegionValidator {
    boolean isCountrySupported(String countryCode);
    boolean isStateSupported(String countryCode, String stateCode);
}
