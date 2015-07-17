package org.DAL;

import org.DAL.model.Interview;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class InterviewService extends InterviewDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    EntityManager getEntityManager() {
        return entityManager;
    }


    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertInterview(Interview interview) {
        super.insertInterview(interview);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateInterview(Interview interview) {
        super.updateInterview(interview);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteInterview(Interview interview) {
        super.deleteInterview(interview);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteInterviewById(long id) {
        super.deleteInterviewById(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Interview getInterviewById(long id) {
        return super.getInterviewById(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Interview> getAllInterviews() {
        return super.getAllInterviews();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Interview> getCurrentInterviews(Date date) {
        return super.getCurrentInterviews(date);
    }
}
