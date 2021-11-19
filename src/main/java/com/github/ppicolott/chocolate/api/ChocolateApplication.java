package com.github.ppicolott.chocolate.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = {"br.com.yaman.notification.hub.api.entity"})
//@EnableJpaRepositories(basePackages = {"br.com.yaman.notification.hub.api.repository"})
@ComponentScan
@EntityScan
@EnableJpaRepositories
public class ChocolateApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChocolateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChocolateApplication.class, args);
		LOGGER.info("Started");
	}

}