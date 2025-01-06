package com.session.october;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories(basePackages = {"com.session.october"})
public class OctoberApplication {

	public static void main(String[] args) {
		SpringApplication.run(OctoberApplication.class, args);
	}
	
//	@PostConstruct
//	public void init() {
//		log.info("Application Initialized");
//	}
//	
//	@PreDestroy
//	public void destroy() {
//		log.info("Destroying the Application");
//	}
}