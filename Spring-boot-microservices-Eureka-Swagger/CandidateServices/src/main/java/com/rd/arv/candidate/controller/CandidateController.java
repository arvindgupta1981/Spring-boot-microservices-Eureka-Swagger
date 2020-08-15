package com.rd.arv.candidate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rd.arv.candidate.entity.Candidate;
import com.rd.arv.candidate.service.CandidateService;

@RestController
public class CandidateController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CandidateController.class);
	
	@Autowired
	private CandidateService service;
	
	@PostMapping(value = "/add")
	public Candidate add(@RequestBody Candidate candidate) {
		LOGGER.info("Candidate Name:{}", candidate.getName());
		
		return candidate;
	}
	
	@GetMapping(value = "/find/{id}")
	public Candidate find(@PathVariable Long id) {
		LOGGER.info("Candidate find id:{}", id);
		return service.findById(id);
	}
	
	@PostMapping(value = "/save")
	public Candidate save(@RequestBody Candidate candidate) {
		LOGGER.info("Candidate Save Name:{}", candidate.getName());
		
		return candidate;
	}
}
