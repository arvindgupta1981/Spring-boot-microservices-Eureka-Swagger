package com.rd.arv.candidate.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.rd.arv.candidate")
@EnableResourceServer
public class CandidateApplication {
	private final String checkTokenEndpointUrl = "http://authorization-server:8090/oauth/check_token";
	
	public static void main(String... args) {
		SpringApplication.run(CandidateApplication.class, args);
	}
	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
		remoteTokenServices.setClientId("candidateapp");
		remoteTokenServices.setClientSecret("1981");
		return remoteTokenServices;
	}
}
