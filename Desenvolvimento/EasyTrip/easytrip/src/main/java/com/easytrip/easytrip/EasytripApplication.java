package com.easytrip.easytrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasytripApplication {

	public static void main(String[] args) {

		SpringApplication.run(EasytripApplication.class, args);
	}

}
