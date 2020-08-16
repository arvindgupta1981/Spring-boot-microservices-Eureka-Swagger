package com.rd.arv.applyjob.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.rd.arv.applyjob")
public class ApplyJobApplication {
	public static void main(String... args) {
		SpringApplication.run(ApplyJobApplication.class, args);
	}
}
