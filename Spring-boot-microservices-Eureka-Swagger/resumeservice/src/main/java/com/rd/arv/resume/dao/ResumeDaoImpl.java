package com.rd.arv.resume.dao;


import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rd.arv.resume.entity.Resume;

@Repository
public class ResumeDaoImpl implements ResumeDao {
	private final static Logger logger = LoggerFactory.getLogger(ResumeDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public ResumeDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Resume findByCandidateId(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Resume> query = session.getNamedQuery("findResumeByCandidateId");
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Resume save(Resume resume) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(resume);
			transaction.commit();
		} catch(Exception ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return resume;
	}
}
