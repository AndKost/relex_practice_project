package org.DAL;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.DAL.model.Report;

@Stateless
public class ReportService extends ReportDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	@Override
	EntityManager getEntityManager() {
		return entityManager;
	}
	
	/*Добавление отчета*/
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertReport(Report report) {
		super.insertReport(report);
	}
	
	
	/*Удаление отчета*/
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remoteReport(long reportId){
		super.remoteReport(reportId);
	}
	
	/*Просмотр отчета(получение отчета по id)*/
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Report getReportById(long id){
		return super.getReportById(id);
	}
	
}
