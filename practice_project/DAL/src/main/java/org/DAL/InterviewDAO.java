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
        Interview i = getEntityManager().find(Interview.class, id);
        if (i != null) getEntityManager().remove(i);
    }

    public Interview getInterviewById(long id) {

        String queryString = "SELECT p FROM Interview p JOIN FETCH p.author WHERE p.id = :id";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);
        Interview l = (Interview) query.getSingleResult();
        return l;
    }

    public List<Interview> getAllInterviews() {
        String queryString = "SELECT p FROM Interview p";
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

