package org.ebi.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("org.ebi.rest.controller"))
                .paths(PathSelectors.any()).build();

    }

    @Bean
    public Mapper mapper(){
        return new DozerBeanMapper();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("EBI").description("REST services")
        .version("1.0")
                .contact(new Contact("Anonymous", "http://ebi.ac.uk", null))
                        .build();
    }
}
