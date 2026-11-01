package com.example.productmanagement.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI productManagementOpenAPI() {
        return new OpenAPI().info(new Info().title("Product Management API")
            .description("Product CRUD, search, sorting and pagination. No order management.")
            .version("1.0.0"));
    }
}
