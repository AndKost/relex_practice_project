package org.DAL;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.DAL.model.Interview;

@Stateless
public class InterviewService extends InterviewDAO {
		
	@PersistenceContext
	EntityManager entityManager;
	@Override
	EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	
	@Override
	public void insertInterview(Interview interview) {
		super.insertInterview(interview);
	}
}
