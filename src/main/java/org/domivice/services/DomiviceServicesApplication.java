package org.domivice.services;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
        basePackages = {"org.domivice.services", "org.domivice.services.userInterface.api.rest", "org.domivice.services.userInterface.api.rest.configs"},
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class DomiviceServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomiviceServicesApplication.class, args);
    }

    @Bean(name = "org.domivice.services.OpenApiGeneratorApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}