package org.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class NewsDAO {
	
	EntityManager em;
	
	public	NewsDAO() {
		em = HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().
				createEntityManager();
	}
	
	/*Добавление новости*/
	public void insertNews(News news)
	{
		em.getTransaction().begin();
		em.persist(news);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Удаление новости по id*/
	public void remoteNews(int newsId){
		em.getTransaction().begin();
		News tmp = em.find(News.class, newsId);
		em.remove(tmp);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Выбираем все новости*/
	public void getAllNews(){
		em.getTransaction().begin();
		Query query = em.createQuery("FROM News");
		List<News> result = query.getResultList();
		em.getTransaction().commit();
		em.close();
	}
	
	/*Получение новости по id*/
	public News getNewsById(long id){
		em.getTransaction().begin();
		News result = em.find(News.class, id);
		em.getTransaction().commit();
		em.close();
		return result;
	}
	
	/*Вперспективе функция редактирования для этого обновление новости*/
	
	
	/*Получение новостей за месяц*/
	
}
