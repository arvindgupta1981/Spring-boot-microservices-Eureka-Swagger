package com.rd.arv.applyjob.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rd.arv.applyjob.starter.ApplyJobApplication;

@RestController
@RequestMapping(path = "/applyjob")
public class ApplyJobController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplyJobApplication.class);
	
	@Value(value = "app.service.candidateservice") private String candidateServiceName;
	@Value(value = "app.service.resumeservice") private String resumeServiceName;
	
	@PostMapping(value = "/apply")
	public String applyJob(@PathVariable Long candidateId) {
		LOGGER.info("Apply job id:{}", candidateId);
		return "";
	}
}
