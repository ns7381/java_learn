package com.nathan.learn.spring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.env")
@Data
public class EnvironmentConfig {
    private String yarnAddress;
    private String yarnBackupAddress;
    private String bdpopsAddress;
    private String hdfsAddress;
}
