package org.DAL.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "adminCode")
public class AdminCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CODE_SEQ")
	@SequenceGenerator(name = "CODE_SEQ", sequenceName = "code_seq", 
		initialValue = 1, allocationSize = 1)
	private long id;
	
	@Column(name = "code", unique = true, nullable = false, insertable = true, 
			updatable = true, length = 45)
	private String code;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "addDate", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private Date addDate;
	
	public AdminCode() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

}
