package com.easytrip.easytrip;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}


	@Bean
	public Docket swaggerConfiguration(){
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.easytrip.easytrip"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiDetails())
				;
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"EasyTrip api",
				"Here you will fine all the REST commands  ",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Diogo Ramos","easytrip.life","dperss@gmail.com"),
				"API License",
				"easytrip.life",
				Collections.emptyList());
	}


}

