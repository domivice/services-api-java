package org.domivice.services.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "org.domivice.services.openapi",
    "org.domivice.services.openapi.*",
    "org.domivice.services.domain.*",
    "org.domivice.services.application.*",
    "org.domivice.services.infrastructure.*",
    "org.domivice.services.web.*",
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
