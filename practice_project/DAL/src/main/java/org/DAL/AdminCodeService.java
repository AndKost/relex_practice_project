package org.DAL;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.DAL.model.AdminCode;

@Stateless
public class AdminCodeService extends AdminCodeDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void addCode(String code) {
		// TODO Auto-generated method stub
		super.addCode(code);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public AdminCode getAdminCodeOfCode(String code) {
		// TODO Auto-generated method stub
		return super.getAdminCodeOfCode(code);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void deleteCode(long id) {
		// TODO Auto-generated method stub
		super.deleteCode(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
