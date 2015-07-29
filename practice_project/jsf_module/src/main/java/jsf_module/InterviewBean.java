package jsf_module;

import org.DAL.CommentService;
import org.DAL.InterviewService;
import org.DAL.UserService;
import org.DAL.model.Admin;
import org.DAL.model.Comment;
import org.DAL.model.Interview;
import org.DAL.model.Person;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ALUCARA on 21.07.2015.
 */


@RequestScoped
@Named(value = "interviewBean")
public class InterviewBean {

    @EJB
    InterviewService interviewService;

    @EJB
    UserService userService;

    @EJB
    CommentService commentService;

    Interview interview = new Interview();

    Integer viewId;

    @PostConstruct
    public void init()
    {
        interview = new Interview();
    }

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
        interview = interviewService.getInterviewById(viewId);
    }

    public InterviewService getInterviewService() {
        return interviewService;
    }

    public void setInterviewService(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public String editInterview() {
        return "edit_interview";
    }

    public String detailsInterview() {
        return "details_interview";
    }

    public String go() {
        return "index_interview";
    }

    public String add() {
        return "add_interview";
    }

    public void validateDate(FacesContext context, UIComponent component, Object value) {
        Date date = (Date) value;
    }

    public void addInterview() {
        interview.setAuthor((Admin) userService.getUserOfLogin("admin2"));
        interviewService.insertInterview(interview);
    }

    public void updateInterview() {
        interviewService.updateInterview(interview);
    }

    public void deleteInterview(long id) {
        interviewService.deleteInterviewById(id);
    }

    public List<Comment> getCommentsById(long id) {
        return commentService.getCommentsByAuthorId(id);
    }

    public List<Interview> getAll() {
        return interviewService.getAllInterviews();
    }
}
