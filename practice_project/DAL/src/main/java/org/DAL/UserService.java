package org.DAL;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService extends UserDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Citizen registrationCitizen(String login, String password,
			String email, String firstName, String lastName) {
		// TODO Auto-generated method stub
		return super.registrationCitizen(login, password, email, firstName, lastName);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Admin registrationAdmin(String login, String password, String email,
			String firstName, String lastName, String phone) {
		// TODO Auto-generated method stub
		return super.registrationAdmin(login, password, email, firstName, lastName,
				phone);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public int changePassword(long id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return super.changePassword(id, oldPassword, newPassword);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Person getUserOfLogin(String login) {
		// TODO Auto-generated method stub
		return super.getUserOfLogin(login);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public int changeInfoAdmin(long id, String firstName, String lastName,
			String phone, String email) {
		// TODO Auto-generated method stub
		return super.changeInfoAdmin(id, firstName, lastName, phone, email);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public int changeInfoCitizen(long id, String firstName, String lastName,
			String email) {
		// TODO Auto-generated method stub
		return super.changeInfoCitizen(id, firstName, lastName, email);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void changeBonusPoint(long id, long bonusPoint) {
		// TODO Auto-generated method stub
		super.changeBonusPoint(id, bonusPoint);
	}
	

}
