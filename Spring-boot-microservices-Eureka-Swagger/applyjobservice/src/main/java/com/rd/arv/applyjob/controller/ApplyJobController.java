package com.rd.arv.applyjob.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rd.arv.applyjob.clients.CandidateClient;
import com.rd.arv.applyjob.starter.ApplyJobApplication;

@RestController
@RequestMapping(path = "/applyjob")
public class ApplyJobController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplyJobController.class);
	
	@Autowired
	private CandidateClient candidateClient; 
	
	@GetMapping(value = "/apply/{id}")
	public void applyJob(@PathVariable("id") Long candidateId) {
		LOGGER.info("Apply job id:{}", candidateId);
		LOGGER.info("Apply Job Name:{} ", candidateClient.find(candidateId).getName());
		
	}
}
