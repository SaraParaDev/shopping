package com.rbc.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * Micro service for Items On Sale.
 *
 * @author SARA
 */
@SpringBootApplication
public class ItemsOnSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.rbc.shopping.ItemsOnSaleApplication.class, args);
    }


    /**
     * Cors configuration to allow requests only from 'shopping.rbc.com'
     *
     * @return WebMvcConfig with Cors Registry mapping.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins("http://localhost:8085");
            }
        };
    }

}
