
package org.DAL;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Interview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROGECT_SEQ")
	@SequenceGenerator(name = "PROGECT_SEQ", sequenceName = "project_seq", 
		initialValue = 1, allocationSize = 1)
	private int id;
	
	@ManyToOne(targetEntity = Admin.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId", referencedColumnName = "adminId", unique = false, 
		nullable = false, insertable = true, updatable = false)
	private Admin author;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "startDate", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private Date startDate;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "finishDate", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private Date finishDate;
	
	
	private ArrayList<Comment> comments;
	
	@ManyToMany(mappedBy = "interviews")
	private ArrayList<Citizen> citizens;
	
	public Interview() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(Admin author) {
		this.author = author;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	public ArrayList<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(ArrayList<Citizen> citizens) {
		this.citizens = citizens;
	}
	
	
}
