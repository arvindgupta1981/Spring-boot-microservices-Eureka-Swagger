package com.rd.arv.applyjob.starter;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.rd.arv.applyjob.clients")
@ComponentScan(basePackages = "com.rd.arv.applyjob")
@EnableHystrix
@EnableHystrixDashboard
@EnableResourceServer
public class ApplyJobApplication {
	private static final String PASSWORD = "1981";
	private static final String CANDIDATEAPP = "candidateapp";
	private final String checkTokenEndpointUrl = "http://authorization-server:8090/oauth/check_token";
	
	public static void main(String... args) {
		SpringApplication.run(ApplyJobApplication.class, args);
	}
	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
		remoteTokenServices.setClientId(CANDIDATEAPP);
		remoteTokenServices.setClientSecret(PASSWORD);
		return remoteTokenServices;
	}
	
	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {
	    return new RequestInterceptor() {
	        @Override
	        public void apply(RequestTemplate requestTemplate) {
	        	System.out.println("++++++++++++++++++++++++++++++requestTokenBearerInterceptor");
	            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
	                    SecurityContextHolder.getContext().getAuthentication().getDetails();

	            requestTemplate.header("Authorization", "bearer " + details.getTokenValue());
	        }
	    };
	}

}
