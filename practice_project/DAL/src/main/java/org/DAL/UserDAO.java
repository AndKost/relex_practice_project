package org.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class UserDAO {
	
	public static void insertUser(User user)
	{
		EntityManager em = HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().
				createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	public static User getUserOfLogin(String login)
	{
		EntityManager em = HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().
				createEntityManager();
		em.getTransaction().begin();
		String q = "FROM User u WHERE u.login =: userLogin";
		Query query = em.createQuery(q);
		query.setParameter("userLogin", login);
		List<User> result = query.getResultList();
		em.getTransaction().commit();
		em.close();
		if (result != null && !result.isEmpty())
			return result.get(0);
		else
			return null;
	}

}
