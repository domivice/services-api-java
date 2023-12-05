package org.domivice.services.web.api.rest.configs;

import org.domivice.services.web.api.rest.models.BookingType;
import org.domivice.services.web.api.rest.models.CertificationStatus;
import org.domivice.services.web.api.rest.models.DocumentRequirementStatus;
import org.domivice.services.web.api.rest.models.DocumentStatus;
import org.domivice.services.web.api.rest.models.LicenceRequirementStatus;
import org.domivice.services.web.api.rest.models.LicenceStatus;
import org.domivice.services.web.api.rest.models.ServiceOfferingType;
import org.domivice.services.web.api.rest.models.ServiceProviderResponseRate;
import org.domivice.services.web.api.rest.models.ServiceProviderStatus;
import org.domivice.services.web.api.rest.models.ServiceStatus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverterConfiguration {

    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.bookingTypeConverter")
    Converter<String, BookingType> bookingTypeConverter() {
        return new Converter<String, BookingType>() {
            @Override
            public BookingType convert(String source) {
                return BookingType.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.certificationStatusConverter")
    Converter<String, CertificationStatus> certificationStatusConverter() {
        return new Converter<String, CertificationStatus>() {
            @Override
            public CertificationStatus convert(String source) {
                return CertificationStatus.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.documentRequirementStatusConverter")
    Converter<String, DocumentRequirementStatus> documentRequirementStatusConverter() {
        return new Converter<String, DocumentRequirementStatus>() {
            @Override
            public DocumentRequirementStatus convert(String source) {
                return DocumentRequirementStatus.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.documentStatusConverter")
    Converter<String, DocumentStatus> documentStatusConverter() {
        return new Converter<String, DocumentStatus>() {
            @Override
            public DocumentStatus convert(String source) {
                return DocumentStatus.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.licenceRequirementStatusConverter")
    Converter<String, LicenceRequirementStatus> licenceRequirementStatusConverter() {
        return new Converter<String, LicenceRequirementStatus>() {
            @Override
            public LicenceRequirementStatus convert(String source) {
                return LicenceRequirementStatus.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.licenceStatusConverter")
    Converter<String, LicenceStatus> licenceStatusConverter() {
        return new Converter<String, LicenceStatus>() {
            @Override
            public LicenceStatus convert(String source) {
                return LicenceStatus.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.serviceOfferingTypeConverter")
    Converter<String, ServiceOfferingType> serviceOfferingTypeConverter() {
        return new Converter<String, ServiceOfferingType>() {
            @Override
            public ServiceOfferingType convert(String source) {
                return ServiceOfferingType.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.serviceProviderResponseRateConverter")
    Converter<String, ServiceProviderResponseRate> serviceProviderResponseRateConverter() {
        return new Converter<String, ServiceProviderResponseRate>() {
            @Override
            public ServiceProviderResponseRate convert(String source) {
                return ServiceProviderResponseRate.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.serviceProviderStatusConverter")
    Converter<String, ServiceProviderStatus> serviceProviderStatusConverter() {
        return new Converter<String, ServiceProviderStatus>() {
            @Override
            public ServiceProviderStatus convert(String source) {
                return ServiceProviderStatus.fromValue(source);
            }
        };
    }
    @Bean(name = "org.domivice.services.web.api.rest.configs.EnumConverterConfiguration.serviceStatusConverter")
    Converter<String, ServiceStatus> serviceStatusConverter() {
        return new Converter<String, ServiceStatus>() {
            @Override
            public ServiceStatus convert(String source) {
                return ServiceStatus.fromValue(source);
            }
        };
    }

}
