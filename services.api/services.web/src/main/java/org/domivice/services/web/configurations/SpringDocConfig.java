package org.domivice.services.web.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean(name = "org.domivice.services.web.configurations.SpringDocConfiguration.apiInfo")
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
