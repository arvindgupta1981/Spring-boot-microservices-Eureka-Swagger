package com.rd.arv.resume.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rd.arv.resume")
public class ResumeApplication {
	public static void main(String... args) {
		SpringApplication.run(ResumeApplication.class, args);
	}
}
