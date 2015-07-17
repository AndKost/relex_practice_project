package org.DAL;


import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

import org.DAL.model.Comment;
import org.DAL.model.Report;

public abstract class ReportDAO {
	
	abstract EntityManager getEntityManager();
	
	/*Добавление отчета*/
	public void insertReport(Report report)
	{
		getEntityManager().persist(report);
	}
	
	/*Удаление отчета*/
	public void remoteReport(long reportId){
		Report tmp = getEntityManager().find(Report.class, reportId);
		getEntityManager().remove(tmp);
	}
	
	/*Просмотр отчета(получение отчета по id)*/
	public Report getReportById(long id){
		Report result = getEntityManager().find(Report.class, id);
		return result;
	}
	/*Выборка отчета за месяц*/
	/*public List<Report> getReportsForMonth(){
		
		return 
	}*/

}
