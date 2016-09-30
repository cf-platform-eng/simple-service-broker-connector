package io.pivotal.cf.service.connector;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

    @Bean
    public HelloRepository helloRepository() {
        return connectionFactory().service("hello", HelloRepository.class);
    }

}