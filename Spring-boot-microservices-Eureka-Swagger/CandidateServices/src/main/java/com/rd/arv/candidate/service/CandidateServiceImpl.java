package com.rd.arv.candidate.service;
/*
 * Business service to manage transactions.
 */

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rd.arv.candidate.dao.CandidateDao;
import com.rd.arv.candidate.entity.Candidate;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {
	private CandidateDao candidateDao;

	@Autowired
	public CandidateServiceImpl(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public Candidate findById(Long id) {
		return candidateDao.findById(id);
	}
	
	@Override
	public Candidate save(Candidate candidate) {
		return candidateDao.save(candidate);
	}
}