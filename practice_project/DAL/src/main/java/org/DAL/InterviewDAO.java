package org.DAL;

import org.DAL.model.Interview;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


public abstract class InterviewDAO {

    public void insertInterview(Interview interview) {
        getEntityManager().persist(interview);
    }

    public void updateInterview(Interview interview) {
        getEntityManager().merge(interview);
    }

    public void deleteInterview(Interview interview) {
        getEntityManager().remove(interview);
    }

    public void deleteInterviewById(long id) {
        getEntityManager().remove(getInterviewById(id));
    }

    public Interview getInterviewById(long id) {
        return getEntityManager().find(Interview.class, id);
    }

    public List<Interview> getAllInterviews() {
        String queryString = "SELECT * FROM Interview";
        Query query = getEntityManager().createQuery(queryString);
        return (List<Interview>) query.getResultList();
    }

    public List<Interview> getCurrentInterviews(Date date) {
        String queryString = "SELECT p FROM Interview p WHERE p.finishDate <= :date";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("date", date);
        return (List<Interview>) query.getResultList();
    }

    abstract EntityManager getEntityManager();
}

