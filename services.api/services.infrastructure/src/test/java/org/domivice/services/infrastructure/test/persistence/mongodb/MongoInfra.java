package org.domivice.services.infrastructure.test.persistence.mongodb;

import org.domivice.services.domain.configurations.ModelMapperConfiguration;
import org.domivice.services.infrastructure.persistence.mongodb.configurations.LicenceIssuerConfiguration;
import org.domivice.services.infrastructure.persistence.mongodb.configurations.LicenceTypeConfiguration;
import org.domivice.services.infrastructure.persistence.mongodb.configurations.MongoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.text.Normalizer;

@EnableAutoConfiguration
@Import({
    ContainerConfiguration.class,
    MongoConfiguration.class,
    LicenceIssuerConfiguration.class,
    LicenceTypeConfiguration.class,
    ModelMapperConfiguration.class
})
public class MongoInfra {
    protected String removeDiacritics(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
            .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
