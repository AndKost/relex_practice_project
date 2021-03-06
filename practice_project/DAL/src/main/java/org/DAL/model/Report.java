package org.DAL.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "report")
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_SEQ")
	@SequenceGenerator(name = "REPORT_SEQ", sequenceName = "info_seq", 
		initialValue = 1, allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false, insertable = true, 
	updatable = true)
	private long id;
	
	@Column(name = "text", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private String text;
	
	@Column(name = "result", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private String result;
	
	@Column(name = "decision", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private String decision;
	
	@ManyToOne(targetEntity = Admin.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId", referencedColumnName = "adminId", unique = false, 
		nullable = false, insertable = true, updatable = false)
	private Admin author;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "date", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private Date date;
	
	@ManyToOne(targetEntity = Admin.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "interviewId", referencedColumnName = "adminId", unique = false, 
		nullable = false, insertable = true, updatable = false)
	private Interview interview;
	
	public Report() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDicision() {
		return decision;
	}
	public void setDicision(String dicision) {
		this.decision = dicision;
	}
	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Admin author) {
		this.author = author;
	}
	public Interview getInterview() {
		return interview;
	}
	public void setInterview(Interview interview) {
		this.interview = interview;
	}
}
