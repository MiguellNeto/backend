package com.miguelneto.backend.conf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ConfigurationProperties("ads04.swagger")
public class Swagger2 {

	 @Value("${back.swagger.path}")
	    private String swaggerPath;

	    private String nome;

	    @Bean
	    public Docket allApi() {
	        List<Parameter> aParameters = new ArrayList<Parameter>();
	        Set<String> protocols = new HashSet<>();
	        protocols.add("http");
	        protocols.add("https");
	        return new Docket(DocumentationType.SWAGGER_2).host(swaggerPath)
	                .groupName("All")
	                .apiInfo(apiInfo())
	                .select()
	                .paths(PathSelectors.any())
	                .build()
	                .protocols(protocols)
	                .ignoredParameterTypes(ApiIgnore.class)
	                .enableUrlTemplating(true).globalOperationParameters(aParameters);
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title(nome)
	                .description("Back")
	                .termsOfServiceUrl("http://localhost:8080")
	                .license("")
	                .licenseUrl("http//localhost:8080")
	                .version("2.0")
	                .build();
	    }
}
