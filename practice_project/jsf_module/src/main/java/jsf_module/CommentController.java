package jsf_module;

import java.sql.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.DAL.CommentService;
import org.DAL.UserService;
import org.DAL.model.Comment;

@SessionScoped
@Named(value = "comment")
public class CommentController {
	
	@EJB
	private CommentService commentService;
	private Comment tmp;
	
	
	
	/*Добавление комментария*/
	public void addComment(){
		tmp = new Comment();
		/*tmp.setAuthor();*/
		
		/*Date tmp_date = new Date();
		tmp.setDate(tmp_date);*/
		
		
		/*Установка количества бонусов за комментариев*/
		commentService.addComment(tmp, 10);
	}
	
	/*Удаление комментария*/
	public void removeComment(long id){
		commentService.removeComment(id);
	}
	
	/*Начисление бонусов за комментарий*/
	
}
