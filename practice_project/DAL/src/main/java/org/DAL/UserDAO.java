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
	 * Проверяет данные нового пользователя.
	 * Возвращает 0, если пользователь ввел коректные данные,
	 * 1, если логин занят, 
	 * 2, если email занят. 
	 */
	/*public int checkNewPerson(Person person)
	{
		Person tmp = getUserOfLogin(person.getLogin());
		if (tmp != null)
			return 1;
		tmp = getUserOfEmail(person.getEmail());
		if (tmp != null)
			return 2;
		return 0;
	}*/
	
	/*
	 * Регистрация нового администратора.
	 * Возвращает объект типа Admin, если новый администратор зарегстрирован,
	 * возвращает null, если логин занят.
	 */
	/*public Admin registrationAdmin(String login, String password, String email,
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
	}*/
	
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
		Person tmp = getUserOfEmail(email);
		int resultCode = 0;
		if (tmp != null)
			resultCode = 1;
		else
			admin.setEmail(email);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
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
		Person tmp = getUserOfEmail(email);
		int resultCode = 0;
		if ((tmp != null) && (tmp.getId() != id))
			resultCode = 1;
		else
			citizen.setEmail(email);
		citizen.setFirstName(firstName);
		citizen.setLastName(lastName);
		return resultCode;
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
