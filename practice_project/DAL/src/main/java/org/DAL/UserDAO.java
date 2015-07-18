package org.DAL;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.Admin;
import org.DAL.model.Citizen;
import org.DAL.model.Person;

public abstract class UserDAO {

	/*
	 * Регистрация нового гражданина.
	 * Возвращает объект типа Citizen, если новый гражданин зарегстрирован,
	 * возвращает null, если логин занят.
	 */
	public Citizen registrationCitizen(String login, String password, String email,
									   String firstName, String lastName)
	{
		Person person = getUserOfLogin(login);
		if (person != null)
			return null;
		Citizen citizen = new Citizen();
		citizen.setLogin(login);
		citizen.setPassword(password);
		citizen.setEmail(email);
		citizen.setFirstName(firstName);
		citizen.setLastName(lastName);
		citizen.setRegistrationDate(new Date());
		citizen.setBonusPoint(10);
		getEntityManager().persist(citizen);
		return citizen;
	}
	
	/*
	 * Регистрация нового администратора.
	 * Возвращает объект типа Admin, если новый администратор зарегстрирован,
	 * возвращает null, если логин занят.
	 */
	public Admin registrationAdmin(String login, String password, String email,
									 String firstName, String lastName, String phone)
	{
		Person person = getUserOfLogin(login);
		if (person != null)
			return null;
		Admin admin = new Admin();
		admin.setLogin(login);
		admin.setPassword(password);
		admin.setEmail(email);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setRegistrationDate(new Date());
		admin.setPhone(phone);
		getEntityManager().persist(admin);
		return admin;
	}
	
	/*
	 * Изменение пароля пользователя.
	 * Возвращает 0 если пароль изменен,
	 * 1 - если старый пароль неверен,
	 * -1 - если пользователь не найден в базе данных.
	 */
	public int changePassword(long id, String oldPassword, String newPassword)
	{
		Person person = getEntityManager().find(Person.class, id);
		if (person == null)
			return -1;
		if (person.getPassword().equals(oldPassword))
			person.setPassword(newPassword);
		else
			return 1;
		return 0;
			
	}
	
	/*
	 * Поиск пользователя по логину.
	 * Возвращает null если пользователь не найден в базе данных.
	 */
	public Person getUserOfLogin(String login)
	{
		String q = "FROM Person p WHERE p.login = :userLogin";
		Query query = getEntityManager().createQuery(q);
		query.setParameter("userLogin", login);
		List<Person> result = query.getResultList();
		if (result != null && !result.isEmpty())
			return result.get(0);
		else
			return null;
	}
	
	/*
	 * Изменение данных администратора.
	 * Возвращает 0 если данные изменены,
	 * -1 - если администратор не найден в базе данных.
	 */
	public int changeInfoAdmin(long id, String firstName, String lastName, String phone, String email)
	{
		Admin admin = getEntityManager().find(Admin.class, id);
		if (admin == null)
			return -1;
		admin.setEmail(email);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setPhone(phone);
		return 0;
	}
	
	/*
	 * Изменение данных пользователя.
	 * Возвращает 0 если данные изменены,
	 * -1 - если пользователь не найден в базе данных.
	 */
	public int changeInfoCitizen(long id, String firstName, String lastName, String email)
	{
		getEntityManager().getTransaction().begin();
		Citizen citizen = getEntityManager().find(Citizen.class, id);
		if (citizen == null)
			return -1;
		citizen.setEmail(email);
		citizen.setFirstName(firstName);
		citizen.setLastName(lastName);
		return 0;
	}
	
	public void changeBonusPoint(long id, long bonusPoint)
	{
		getEntityManager().getTransaction().begin();
		Citizen citizen = getEntityManager().find(Citizen.class, id);
		citizen.setBonusPoint(bonusPoint);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}

	abstract EntityManager getEntityManager();

}
