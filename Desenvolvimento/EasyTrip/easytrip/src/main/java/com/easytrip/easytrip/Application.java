package com.easytrip.easytrip;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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




	//private UserDetailsImpl serviceUser;



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


/*
			User user = new User(
					"diogo" ,
					"123456",
					"teste"
					);

			//Trip travel= new Trip("origin"+ i,  "destiny",  "01-02-2018",  "01-02-2018",  "accommodation",  "transportation");

			//serviceTravel.saveOrUpdate(travel);
			serviceUser.build(user);



*/

	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.easytrip.easytrip"))
				.build()
				.apiInfo(apiDetails())
				;
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Adress book api",
				"sample api  ",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Diogo Ramos","easytrip.life","dperss@gmail.com"),
				"API License",
				"easytrip.life",
				Collections.emptyList());
	}


}

