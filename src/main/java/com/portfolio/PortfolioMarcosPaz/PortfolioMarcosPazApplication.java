package com.portfolio.PortfolioMarcosPaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class PortfolioMarcosPazApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioMarcosPazApplication.class, args);
	}



@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://marcosep192000.herokuapp.com").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}