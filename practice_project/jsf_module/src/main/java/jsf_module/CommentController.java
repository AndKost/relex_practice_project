package jsf_module;

import java.util.List;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.DAL.CommentService;
import org.DAL.InterviewService;
import org.DAL.UserService;
import org.DAL.model.Citizen;
import org.DAL.model.Comment;
import org.DAL.model.Interview;


@SessionScoped
@Named(value = "comment")
public class CommentController implements Serializable {
	
	@EJB
	private CommentService commentService;
	private InterviewService intervService;
	private Comment tmp;
	
	public Comment getTmp() {
		return tmp;
	}

	public void setTmp(Comment tmp) {
		this.tmp = tmp;
	}

	/*Добавление комментария*/
	public void addComment(){
		
		/*Установили текущее время*/
		Date current_date = new Date(System.currentTimeMillis());
		tmp.setDate(current_date);
		
		/*Установили id*/
		tmp.setId(12);
		tmp.setNumberOfVotes(100);
		tmp.setPremoderation(false);
		
		/*Cсылка на определенное предложение*/
		Interview intervTmp = intervService.getInterviewById(2);
		tmp.setInterview(intervTmp);
		
		
		List<Citizen> t = new ArrayList<Citizen>();
		//t.add(intervTmp);
		tmp.setInterviews(t);
		
		/*Установка количества бонусов за комментариев*/
		commentService.addComment(tmp, 10);
	}
	
	/*Удаление комментария*/
	public void removeComment(long id){
		commentService.removeComment(id);
	}
	
	/*Начисление бонусов за комментарий*/
	
}
