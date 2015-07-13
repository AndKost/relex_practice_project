package org.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class UserDAO {
	
	EntityManager em;
	
	public UserDAO() 
	{
		em = HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().
				createEntityManager();
	}
	
	public void insertUser(Person user)
	{
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	public Person getUserOfLogin(String login)
	{
		EntityManager em = HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().
				createEntityManager();
		em.getTransaction().begin();
		String q = "FROM Person u WHERE u.login = :userLogin";
		Query query = em.createQuery(q);
		query.setParameter("userLogin", login);
		List<Person> result = query.getResultList();
		em.getTransaction().commit();
		em.close();
		if (result != null && !result.isEmpty())
			return result.get(0);
		else
			return null;
	}

}
