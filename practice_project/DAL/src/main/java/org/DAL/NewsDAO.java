package org.DAL;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.Admin;
import org.DAL.model.News;

import jsf_module.BY;
import jsf_module.SELECT;

public abstract class NewsDAO {
	
	/*
	 * Добавление новости.
	 * Возвращает объект типа News, если новая новость добавлена,
	 * null, если администратор не найден в база данных.
	 */
	public News insertNews(String title, String text, String shortText, long adminId)
	{
		Admin admin = getEntityManager().find(Admin.class, adminId);
		if (admin == null)
			return null;
		News news = new News();
		news.setTitle(title);
		news.setText(text);
		news.setShortText(shortText);
		news.setDate(new Date());
		news.setAuthor(admin);
		getEntityManager().persist(news);
		return news;
	}
	
	/*
	 * Удаление новости по id.
	 * Возвращает 0, если новость удалена,
	 * 1, если новость не найдена.
	 */
	public int remoteNews(long newsId){
		News news = getEntityManager().find(News.class, newsId);
		if (news == null)
			return 1;
		getEntityManager().remove(news);
		return 0;
	}
	
	/*
	 * Выбираем все новости за один месяц.
	 * параметр date - строка в формате: год-месяц.
	 */
	public List<News> getAllNews(String date){
		String q = "WHERE `date` LIKE ':curentDate-%'";
		Query query = getEntityManager().createQuery(q);
		query.setParameter("date", date);
		List<News> result = query.getResultList();
		return result;
	}
	
	/*
	 * Получение новости по id.
	 * Возвращает объект типа News, если новость найдена,
	 * null, если новость не найдена.
	 */
	public News getNewsById(long id){
		News result = getEntityManager().find(News.class, id);
		return result;
	}
	
	/*
	 * Редактирование заголовка новости.
	 * Возвращает 0, если заголовок изменен,
	 * -1, если новость не найдена.
	 */
	public int changeTitle(long id, String title)
	{
		News news = getNewsById(id);
		if (news == null)
			return -1;
		news.setTitle(title);
		return 0;
	}
	
	/*
	 * Редактирование текста новости.
	 * Возвращает 0, если текст изменен,
	 * -1, если новость не найдена.
	 */
	public int changeText(long id, String text)
	{
		News news = getNewsById(id);
		if (news == null)
			return -1;
		news.setText(text);
		return 0;
	}
	
	/*
	 * Редактирование короткого текста новости.
	 * Возвращает 0, если короткий текст изменен,
	 * -1, если новость не найдена.
	 */
	public int changeShortText(long id, String shortText)
	{
		News news = getNewsById(id);
		if (news == null)
			return -1;
		news.setShortText(shortText);
		return 0;
	}
	
	/*Получение крайних трех записей новостей*/
	public List<News> getTreeLastNews(){
		String q = "SELECT * FROM news ORDER BY Date LIMIT 3";
		Query query = getEntityManager().createQuery(q);
		List<News> result = query.getResultList();
		return result;
	}
	
	
	abstract EntityManager getEntityManager();
	
}
