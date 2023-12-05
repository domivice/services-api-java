package org.domivice.services.web.api;

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
    basePackages = {"org.domivice.services.web.api", "org.domivice.services.web.api.rest" , "org.domivice.services.web.api.rest.configs"},
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class DomiviceServicesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomiviceServicesApiApplication.class, args);
    }

    @Bean(name = "org.domivice.services.web.api.OpenApiGeneratorApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}