package org.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.News;

public class NewsDAO {
	
	private EntityManager em;
	
	public	NewsDAO() {
		setEntityManager(HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().
				createEntityManager());
	}
	
	/*Добавление новости*/
	public void insertNews(News news)
	{
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(news);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}
	
	/*Удаление новости по id*/
	public void remoteNews(int newsId){
		getEntityManager().getTransaction().begin();
		News tmp = getEntityManager().find(News.class, newsId);
		getEntityManager().remove(tmp);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}
	
	/*Выбираем все новости*/
	public void getAllNews(){
		getEntityManager().getTransaction().begin();
		Query query = getEntityManager().createQuery("FROM News");
		List<News> result = query.getResultList();
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}
	
	/*Получение новости по id*/
	public News getNewsById(long id){
		getEntityManager().getTransaction().begin();
		News result = getEntityManager().find(News.class, id);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
		return result;
	}

	EntityManager getEntityManager() {
		return em;
	}

	void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	/*Вперспективе функция редактирования для этого обновление новости*/
	
	
	/*Получение новостей за месяц*/
	
}
