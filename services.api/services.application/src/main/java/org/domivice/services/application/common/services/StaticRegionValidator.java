package org.domivice.services.application.common.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class StaticRegionValidator implements RegionValidator {
    private static final Map<String, Set<String>> countryStateMap = new HashMap<>();

    static {
        countryStateMap.put("US", Set.of("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
        countryStateMap.put("CA", Set.of("AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT"));
    }

    /**
     * @param countryCode The country code
     * @return returns true if the country is supported
     */
    @Override
    public boolean isCountrySupported(String countryCode) {
        if(countryCode == null){
            return false;
        }
        return countryStateMap.containsKey(countryCode);
    }

    /**
     * @param countryCode The country Code
     * @param stateCode The state code
     * @return returns true if the state is supported
     */
    @Override
    public boolean isStateSupported(String countryCode, String stateCode) {
        if(countryCode == null || stateCode == null){
            return false;
        }
        return countryStateMap.containsKey(countryCode) && countryStateMap.get(countryCode).contains(stateCode);
    }
}
