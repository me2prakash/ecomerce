package com.vimco.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)// why using this?
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
    	String groupName = "Swagger";
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build().groupName(groupName).apiInfo(apiInfo());                                           
    }

    // Describe the apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("test")
                .description("Test")
                .version("1.0.0")
                .license("vvv")
                .build();
    }
}
