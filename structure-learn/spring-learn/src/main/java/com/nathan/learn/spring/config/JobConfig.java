package com.nathan.learn.spring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.job")
@Data
public class JobConfig {
    private String queue;
    private int maxMaps;
    private int mapBandwidth;
}
