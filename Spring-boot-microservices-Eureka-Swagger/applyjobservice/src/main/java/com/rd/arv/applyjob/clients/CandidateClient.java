package com.rd.arv.applyjob.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rd.arv.candidate.entity.Candidate;

import feign.hystrix.FallbackFactory;
//Feign creates a Ribbon load balancer at client side
@FeignClient(name = "candidateservice", fallbackFactory = HystrixCandidateFallback.class)
public interface CandidateClient {
	@GetMapping(value = "/candidate/find/{id}")
	public Candidate find(@PathVariable Long id); 	
}

@Component
class HystrixCandidateFallback implements FallbackFactory<Candidate>{
	
	@Override
	public Candidate create(Throwable err) {
		System.out.println("+++++++++++++++++++++++++++++++candiadte client error" + err);
		Candidate candidate = new Candidate();
		candidate.setId(0l);
		candidate.setName("");
		return candidate ;
	}
	
}