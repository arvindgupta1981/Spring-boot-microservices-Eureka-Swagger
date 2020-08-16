package com.rd.arv.applyjob.clients;

import org.springframework.context.annotation.Bean;

import feign.Contract;

public class CanididateServiceConfiguration {
	@Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    /*@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }*/
}
