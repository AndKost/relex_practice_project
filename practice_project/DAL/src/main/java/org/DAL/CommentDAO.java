package org.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CommentDAO {
	
	EntityManager em;
	
	public	CommentDAO() {
		em = HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().
				createEntityManager();
	}
	
	/*Добавление предложение*/
	public void insertComment(Comment сomment)
	{
		em.getTransaction().begin();
		em.persist(сomment);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Удаление предложение по id*/
	public void remoteComment(int сommentId){
		em.getTransaction().begin();
		Comment tmp = em.find(Comment.class, сommentId);
		em.remove(tmp);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Выбираем все предложения к определенному опросу???*/
	
	/*Получение предложение по id*/
	public Comment getCommentById(long id){
		em.getTransaction().begin();
		Comment result = em.find(Comment.class, id);
		em.getTransaction().commit();
		em.close();
		return result;
	}

	/*Инкремент рейтинга*/
	public void incRate(long id) {
		em.getTransaction().begin();
		/*Получили комментарий*/
		Comment tmp = getCommentById(id);
		int vote = tmp.getNumberOfVotes();
		tmp.setNumberOfVotes(++vote);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
