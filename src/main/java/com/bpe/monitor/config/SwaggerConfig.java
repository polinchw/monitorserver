package com.bpe.monitor.config;


import com.bpe.monitor.version.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Navigate to http://localhost:8081/swagger-ui.html#
 *
 * Created by polinchw on 6/5/17.
 *
 */
@Configuration
@EnableSwagger2
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class SwaggerConfig {

    @Autowired
    private Version version;

    private static String versionNumber;

    @Bean
    public Docket api() {
        try {
            versionNumber = version.getVersion();
        } catch (Exception e) {
            versionNumber = "Unknown";
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());


    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Monitor Server REST API running on JDK 8 u 131",
                "Rest API for storing Rasberry PI monitoring data. Version "+versionNumber,
                "API TOS",
                "Terms of service",
                "polinchw@gmail.com",
                "License of API",
                "API license URL");
        return apiInfo;
    }
}
