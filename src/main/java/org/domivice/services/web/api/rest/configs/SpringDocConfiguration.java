package org.domivice.services.web.api.rest.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "org.domivice.services.web.api.rest.configs.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Services API")
                                .description("The services API")
                                .contact(
                                        new Contact()
                                                .name("Nelson Kana")
                                                .url("https://api.domivice.com")
                                                .email("nelson.kana@domivice.com")
                                )
                                .version("1.0.0")
                )
        ;
    }
}