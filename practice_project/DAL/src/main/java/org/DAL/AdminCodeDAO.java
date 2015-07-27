package org.DAL;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.AdminCode;

public abstract class AdminCodeDAO {
	
	public void addCode(String code)
	{
		AdminCode adminCode = new AdminCode();
		adminCode.setCode(code);
		adminCode.setAddDate(new Date());
		getEntityManager().persist(adminCode);
	}
	
	public AdminCode getAdminCodeOfCode(String code)
	{
		String q = "FROM adminCode a WHERE a.code = :code";
		Query query = getEntityManager().createQuery(q);
		query.setParameter("code", code);
		List<AdminCode> result = query.getResultList();
		if (result != null && !result.isEmpty())
			return result.get(0);
		else
			return null;
	}
	
	public void deleteCode(long id)
	{
		AdminCode adminCode = getEntityManager().find(AdminCode.class, id);
		if (adminCode != null)
			getEntityManager().remove(adminCode);
	}
	
	abstract EntityManager getEntityManager();

}
