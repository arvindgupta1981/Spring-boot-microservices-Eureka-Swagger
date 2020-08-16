package com.rd.arv.candidate.dao;


import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rd.arv.candidate.entity.Candidate;

@Repository
public class CandidateDaoImpl implements CandidateDao {
	private final static Logger logger = LoggerFactory.getLogger(CandidateDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public CandidateDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Candidate findById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Candidate> query = session.getNamedQuery("findCandidateById");
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Candidate save(Candidate candidate) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(candidate);
		transaction.commit();
		session.close();
		return candidate;
	}
}
