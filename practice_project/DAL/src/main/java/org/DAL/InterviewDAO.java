package org.DAL;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.Interview;
import org.DAL.model.News;

public abstract class InterviewDAO {
	
	
	
	/*Добавление опроса*/
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertInterview(Interview interview)
	{
		getEntityManager().persist(interview);
	}
	
	/*Удаление опроса по id*/
	public void remoteNews(int interviewId){
		getEntityManager().getTransaction().begin();
		Interview tmp = getEntityManager().find(Interview.class, interviewId);
		getEntityManager().remove(tmp);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}
	
	/*Выбираем все опросы*/
	public void getAllInterviews(){
		getEntityManager().getTransaction().begin();
		String q = "SELECT * FROM Interview";
		Query query = getEntityManager().createQuery(q);
		List<News> result = query.getResultList();
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}
	
	/*Получение опроса по id*/
	public Interview getInterviewById(long id){
		getEntityManager().getTransaction().begin();
		Interview result = getEntityManager().find(Interview.class, id);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
		return result;
	}

	abstract EntityManager getEntityManager();

	/*Изменение*/
}
