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
}
