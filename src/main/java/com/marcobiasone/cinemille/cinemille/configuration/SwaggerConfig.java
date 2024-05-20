package com.marcobiasone.cinemille.cinemille.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class SwaggerConfig {

    private final CineMilleConfiguration cmc;
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title(cmc.getSwaggerTitle())
                .version(cmc.getSwaggerVersion())
                .description(cmc.getSwaggerDescription()));
    }
}
