package com.rd.arv.proxy.strater;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import com.rd.arv.interceptor.UserContextInterceptor;
import com.rd.arv.proxy.filters.AuthenticationAuthPreFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
//@ComponentScan(basePackages = "com.rd.arv.proxy")
public class ProxyApplication {	
	public static void main(String... args) {
		SpringApplication.run(ProxyApplication.class, args);
	}
	
	/*@Bean
	public AuthenticationAuthPreFilter authenticationAuthPreFilter() {
	    return new AuthenticationAuthPreFilter();
	}
	
	//@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
		if (interceptors == null) {
			template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
		} else {
			interceptors.add(new UserContextInterceptor());
			template.setInterceptors(interceptors);
		}
		return template;
	}*/
}
