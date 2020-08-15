package com.rd.arv.candidate.dao;

import com.rd.arv.candidate.entity.Candidate;

public interface CandidateDao {
	Candidate findById(Long id);
}
