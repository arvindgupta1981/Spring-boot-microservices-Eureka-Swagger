package com.rd.arv.applyjob.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rd.arv.candidate.entity.Candidate;
//Feign creates a Ribbon load balancer at client side
@FeignClient(name = "CANDIDATESERVICE", configuration = CanididateServiceConfiguration.class)
public interface CandidateClient {
	@GetMapping(value = "/find/{id}")
	public Candidate find(@PathVariable Long id); 	
}
