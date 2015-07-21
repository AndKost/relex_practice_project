package org.DAL;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.DAL.model.AdminCode;
import org.DAL.model.UserRoles;

@Stateless
public class UserRolesService extends UserRolesDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addUser(UserRoles userRole) {
		// TODO Auto-generated method stub
		super.addUser(userRole);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		super.deleteUser(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public List<AdminCode> getUserRolesOfLogin(String login) {
		// TODO Auto-generated method stub
		return super.getUserRolesOfLogin(login);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
