package com.rbc.shopping.swagger;

import com.rbc.shopping.util.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger Configuration class.
 *
 * @author SARA
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * Configuration based on the base package and path regex.
     *
     * @return Docket with base package and path regex details for documentation.
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(AppConstants.BASE_PACKAGE))
                .paths(regex(AppConstants.PATH_REGEX))
                .build()
                .apiInfo(metaInfo());
    }

    /**
     * Meta info for Swagger page.
     *
     * @return Returns ApiInfo object with meta info for swagger documentation.
     */
    private ApiInfo metaInfo() {

        final ApiInfo apiInfo = new ApiInfo(
                AppConstants.DOC_TITLE,
                AppConstants.DOC_TITLE_DESC,
                AppConstants.DOC_VERSION,
                AppConstants.DOC_TERMS_OF_SERVICE,
                AppConstants.DOC_CONTACT_NAME,
                AppConstants.EMPTY_STRING,
                AppConstants.DOC_LICENSE_URL
        );

        return apiInfo;
    }
}
