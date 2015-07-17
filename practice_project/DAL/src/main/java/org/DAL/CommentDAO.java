package org.DAL;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.Comment;

public abstract class CommentDAO {
	
	abstract EntityManager getEntityManager1();
	
	/*Добавление предложение*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertComment(Comment сomment)
	{
		getEntityManager1().persist(сomment);
	}
	
	/*Удаление предложение по id*/
	public void remoteComment(int сommentId){
		Comment tmp = getEntityManager1().find(Comment.class, сommentId);
		getEntityManager1().remove(tmp);
	}
	
	/*Получение предложение по id*/
	public Comment getCommentById(long id){
		Comment result = getEntityManager1().find(Comment.class, id);
		return result;
	}

	/*Начисление бонусов за голосование*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incRate(long id) {
		/*Получили комментарий*/
		Comment tmp = getCommentById(id);
		int vote = tmp.getNumberOfVotes();
		tmp.setNumberOfVotes(++vote);
	}

	
}
