package com.rd.arv.candidate.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = "com.rd.arv.candidate")
public class CandidateApplication {	
	public static void main(String... args) {
		SpringApplication.run(CandidateApplication.class, args);
	}
}
