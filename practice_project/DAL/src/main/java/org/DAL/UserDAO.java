package org.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.Admin;
import org.DAL.model.Citizen;
import org.DAL.model.Person;

public abstract class UserDAO {

	/*
	 * Регистрация нового пользователя.
	 */
	public void registrationPerson(Person person)
	{
		getEntityManager().persist(person);
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
	 * Поиск пользователя по email.
	 * Возвращает null если пользователь не найден в базе данных.
	 */
	public Person getUserOfEmail(String email)
	{
		String q = "FROM Person p WHERE p.email = :userEmail";
		Query query = getEntityManager().createQuery(q);
		query.setParameter("userEmail", email);
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
		int resultCode = 0;
		Person person = getUserOfEmail(email);
		if (!email.equals("") && person != null && id != person.getId())
			resultCode = 1;
		else
			admin.setEmail(email);
		if (!firstName.equals(""))
			admin.setFirstName(firstName);
		if (!lastName.equals(""))
			admin.setLastName(lastName);
		if (!phone.equals(""))
			admin.setPhone(phone);
		return resultCode;
	}
	
	/*
	 * Изменение данных пользователя.
	 * Возвращает 0 если данные изменены,
	 * -1 - если пользователь не найден в базе данных.
	 */
	public int changeInfoCitizen(long id, String firstName, String lastName, String email)
	{
		Citizen citizen = getEntityManager().find(Citizen.class, id);
		if (citizen == null)
			return -1;
		int resultCode = 0;
		Person person = getUserOfEmail(email);
		if (!email.equals("") && person != null && id != person.getId())
			resultCode = 1;
		else
			citizen.setEmail(email);
		if (!firstName.equals(""))
			citizen.setFirstName(firstName);
		if (!lastName.equals(""))
			citizen.setLastName(lastName);
		return resultCode;
	}

	abstract EntityManager getEntityManager();

}
