package jsf_module;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.DAL.NewsService;
import org.DAL.model.News;

@SessionScoped
@Named(value = "news")
public class NewsController implements Serializable {

	@EJB
	private NewsService newsService;
	
	/*Получаем 3 свежих новости для главной страницы*/
	public List<News> getTreeLastNews(){
		return newsService.getTreeLastNews();
	}
}
