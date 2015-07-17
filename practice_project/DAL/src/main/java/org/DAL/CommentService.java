package org.DAL;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.DAL.model.Comment;

@Stateless
public class CommentService extends CommentDAO {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	EntityManager getEntityManager1() {
		return entityManager;
	}
	
	/*Добавление предложения*/
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertComment(Comment сomment) {
		super.insertComment(сomment);
	}
	
	/*Удаление предложения*/
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remoteComment(int сommentId){
		super.remoteComment(сommentId);
	}
	
	/*Начисление бонусов за голосование*/
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incRate(long id) {
		super.incRate(id);
	}
	
	
}
