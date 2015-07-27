package org.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.AdminCode;
import org.DAL.model.UserRoles;

public abstract class UserRolesDAO {
	
	public void addUser(UserRoles userRole)
	{
		getEntityManager().persist(userRole);
	}
	
	public void deleteUser(long id)
	{
		UserRoles userRole = getEntityManager().find(UserRoles.class, id);
		if (userRole != null)
			getEntityManager().remove(userRole);
	}
	
	public List<AdminCode> getUserRolesOfLogin(String login)
	{
		String q = "FROM userRoles u WHERE u.login = :login";
		Query query = getEntityManager().createQuery(q);
		query.setParameter("login", login);
		List<AdminCode> result = query.getResultList();
		return result;
	}
	
	abstract EntityManager getEntityManager();

}
