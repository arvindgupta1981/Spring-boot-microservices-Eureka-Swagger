package com.rd.arv.candidate.service;
/*
 * Business service to manage transactions.
 */

import com.rd.arv.candidate.entity.Candidate;

public interface CandidateService {
	Candidate findById(Long id);
	Candidate save(Candidate candidate);
}
