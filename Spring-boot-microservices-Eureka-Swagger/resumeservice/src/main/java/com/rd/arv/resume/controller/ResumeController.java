package com.rd.arv.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rd.arv.resume.entity.Resume;
import com.rd.arv.resume.service.ResumeService;

@RestController
@RequestMapping(path = "/resume")
public class ResumeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResumeController.class);
	
	@Autowired
	private ResumeService service;
	
	@PostMapping(value = "/update")
	public Resume add(@RequestBody Resume resume) {
		LOGGER.info("Resume edu:{}", resume.getEducation());
		
		return resume;
	}
	
	@GetMapping(value = "/find/{id}")
	public Resume find(@PathVariable Long id) {
		LOGGER.info("Resume find id:{}", id);
		return service.findByCandidateId(id);
	}
	
	@PostMapping(value = "/save")
	public Resume save(@RequestBody Resume resume) {
		LOGGER.info("Resume Save Name:{}", resume.getEducation()	);
		
		return resume;
	}
}
