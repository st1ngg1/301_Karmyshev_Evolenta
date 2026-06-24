package com.example.location.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI locationOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Location Service API")
                        .description("Сервис хранения данных о городах и координатах")
                        .version("1.0"));
    }
}
