package com.rd.arv.resume.service;

import com.rd.arv.resume.entity.Resume;

public interface ResumeService {
	Resume findByCandidateId(Long id);
	Resume save(Resume resume);
}
