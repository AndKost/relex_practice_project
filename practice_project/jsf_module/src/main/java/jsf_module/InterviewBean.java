package jsf_module;

import org.DAL.InterviewService;
import org.DAL.UserService;
import org.DAL.model.Admin;
import org.DAL.model.Interview;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ALUCARA on 21.07.2015.
 */


@RequestScoped
@Named(value = "interviewBean")
public class InterviewBean implements Serializable {

    // @Inject
    // Conversation conversation;

    @EJB
    InterviewService interviewService;

    @EJB
    UserService userService;

    Interview interview = new Interview();

    Integer viewId;

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
        interview = new Interview();
        return "add_interview";
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

    public List<Interview> getAll() {
        return interviewService.getAllInterviews();
    }

}
