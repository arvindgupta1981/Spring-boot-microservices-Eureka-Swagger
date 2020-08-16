package com.rd.arv.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rd.arv.resume.entity.Resume;
import com.rd.arv.service.dao.ResumeDao;

@Service
public class ResumeServiceImpl implements ResumeService {
	
	@Autowired
	private ResumeDao resumeDao;
	
	@Override
	public Resume findByCandidateId(Long id) {
		return resumeDao.findByCandidateId(id);
	}

	@Override
	public Resume save(Resume resume) {		
		return resumeDao.save(resume);
	}
}