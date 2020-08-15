package com.rd.arv.configuration.service.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationsApplication {
	public static void main(String... args) {
		SpringApplication.run(ConfigurationsApplication.class, args);
	}
}
