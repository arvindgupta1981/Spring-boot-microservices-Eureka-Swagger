package com.rd.arv.applyjob.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.rd.arv.applyjob.clients")
@ComponentScan(basePackages = "com.rd.arv.applyjob")
public class ApplyJobApplication {
	public static void main(String... args) {
		SpringApplication.run(ApplyJobApplication.class, args);
	}
}
