package org.domivice.services.application.common.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandBusConfiguration {
    @Bean
    public CommandBus configureCommandBus() {
        CommandBus commandBus = SimpleCommandBus.builder().build();
        commandBus.registerHandlerInterceptor(new BeanValidationInterceptor<>());
        return commandBus;
    }

    @Qualifier("messageSerializer")
    @Bean
    public JacksonSerializer messageSerializer(ObjectMapper mapper) {
        return JacksonSerializer.builder()
            .objectMapper(mapper)
            .lenientDeserialization()
            .defaultTyping()
            .build();
    }
}
