package com.rd.arv.resume.dao;

import com.rd.arv.resume.entity.Resume;

public interface ResumeDao {
	Resume findByCandidateId(Long id);
	Resume save(Resume resume);
}
