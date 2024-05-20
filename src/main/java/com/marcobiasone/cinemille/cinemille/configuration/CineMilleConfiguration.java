package com.marcobiasone.cinemille.cinemille.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "cinemille-configuration")
@Configuration
@Data
@EnableScheduling
public class CineMilleConfiguration {

    private String swaggerDescription;

    private String swaggerTitle;

    private String swaggerVersion;
}
