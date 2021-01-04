/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv;

import java.util.Collections;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SmartpvApplication.
 */
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class SmartpvApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SmartpvApplication.class, args);
	}

	
	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.psut.smartpv.controller")).build().apiInfo(apiInfo());
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {

		return new ApiInfo("Smart Pv Project ", " backend api.", null, null, null,
				"Author : Mohammed Baker & Abd-Alqader Okasha ", "  ", Collections.emptyList());
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Amman")); // It will set UTC timezone
	}

	/**
	 * Rest template.
	 *
	 * @return the rest template
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
