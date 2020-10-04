package com.arv.rd.auth.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableAuthorizationServer
@ComponentScan(basePackages = "com.rd.arv.auth")
public class AuthorizationServerApplication {
	public static void main(String...args) {
		SpringApplication.run(AuthorizationServerApplication.class, args);
	}
}