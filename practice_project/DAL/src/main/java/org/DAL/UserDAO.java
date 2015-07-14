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
	
	public void registrationUser(Person user)
	{
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Person> getAllUsers()
	{
		em.getTransaction().begin();
		List<Person> result = em.createQuery("FROM Person").getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
	}
	
	public void changePassword(long id, String newPassword)
	{
		em.getTransaction().begin();
		Person person = em.find(Person.class, id);
		person.setPassword(newPassword);
		em.getTransaction().commit();
		em.close();
	}
	
	public Person getUserOfLogin(String login)
	{
		EntityManager em = HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().
				createEntityManager();
		em.getTransaction().begin();
		String q = "FROM Person p WHERE p.login = :userLogin";
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
	
	public void changeInfoAdmin(long id, String firstName, String lastName, String phone, String email)
	{
		em.getTransaction().begin();
		Admin admin = em.find(Admin.class, id);
		admin.setEmail(email);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setPhone(phone);
		em.getTransaction().commit();
		em.close();
	}
	
	public void changeInfoCitizen(long id, String firstName, String lastName, String email)
	{
		em.getTransaction().begin();
		Citizen citizen = em.find(Citizen.class, id);
		citizen.setEmail(email);
		citizen.setFirstName(firstName);
		citizen.setLastName(lastName);
		em.getTransaction().commit();
		em.close();
	}
	
	public void changeBonusPoint(long id, long bonusPoint)
	{
		em.getTransaction().begin();
		Citizen citizen = em.find(Citizen.class, id);
		citizen.setBonusPoint(bonusPoint);
		em.getTransaction().commit();
		em.close();
	}

}
