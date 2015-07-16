package org.DAL;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NewsService extends NewsDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public News insertNews(String title, String text, String shortText,
			long adminId) {
		// TODO Auto-generated method stub
		return super.insertNews(title, text, shortText, adminId);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public int remoteNews(long newsId) {
		// TODO Auto-generated method stub
		return super.remoteNews(newsId);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public List<News> getAllNews(String date) {
		// TODO Auto-generated method stub
		return super.getAllNews(date);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public News getNewsById(long id) {
		// TODO Auto-generated method stub
		return super.getNewsById(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public int changeTitle(long id, String title) {
		// TODO Auto-generated method stub
		return super.changeTitle(id, title);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public int changeText(long id, String text) {
		// TODO Auto-generated method stub
		return super.changeText(id, text);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public int changeShortText(long id, String shortText) {
		// TODO Auto-generated method stub
		return super.changeShortText(id, shortText);
	}

	@Override
	EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
