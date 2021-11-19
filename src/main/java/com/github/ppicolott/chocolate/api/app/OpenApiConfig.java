package com.github.ppicolott.chocolate.api.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customConfiguration(){
		return new OpenAPI()
				.components(new Components())
				.info(
						new Info()
						.title("Chocolate-API")
						.description("Chocolate-API")
						.version("1.0.0-SNAPSHOT")
						.license(new License().name("PPICOLOTT All Rights Reserved").url("https://github.com/ppicolott"))
						.termsOfService("https://github.com/ppicolott")
					);
		
	}

}
