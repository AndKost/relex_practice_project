package org.DAL;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NewsService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	EntityManager getEntityManager() {
			// TODO Auto-generated method stub
			return entityManager;
	}
}
