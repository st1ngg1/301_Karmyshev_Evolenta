package com.example.person.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI personOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Person Service API")
                        .description("Сервис хранения данных пользователей")
                        .version("1.0"));
    }
}
