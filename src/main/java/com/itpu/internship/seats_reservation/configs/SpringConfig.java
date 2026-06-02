package com.itpu.internship.seats_reservation.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("TestMe.v2-API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itpu.seats_reservation.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
}
