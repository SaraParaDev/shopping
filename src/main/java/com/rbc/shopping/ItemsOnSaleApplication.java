package com.rbc.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Micro service for Items On Sale.
 * Scheduling is implemented in {@link com.rbc.shopping.scheduler.DataScheduler}
 * Swagger is implemented in {@link com.rbc.shopping.swagger.SwaggerConfig}
 * Security is implemented in {@link com.rbc.shopping.security.JWTTokenHandlerImpl}
 * Exception is handled in {@link com.rbc.shopping.exception.UserExceptionController}
 * Endpoints is implemented in {@link com.rbc.shopping.controller.ItemRecommendationControllerImpl}
 *
 * @author SARA
 */
@SpringBootApplication
@EnableScheduling
public class ItemsOnSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.rbc.shopping.ItemsOnSaleApplication.class, args);
    }
}
