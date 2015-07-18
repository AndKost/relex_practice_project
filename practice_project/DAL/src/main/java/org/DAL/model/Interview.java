
package org.DAL.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "interview")
public class Interview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INTERVIEW_SEQ")
	@SequenceGenerator(name = "INTERVIEW_SEQ", sequenceName = "info_seq", 
	initialValue = 1, allocationSize = 1)	
	@Column(name = "id", unique = true, nullable = false, insertable = true, 
	updatable = true)
	private long id;
	
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
	
	@Column(name = "text", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private String text;
	
	@OneToMany(mappedBy = "interview")
	private List<Comment> comments = new ArrayList<Comment>();
	
	@ManyToMany(mappedBy = "interviews")
	private List<Citizen> citizens = new ArrayList<Citizen>();
	
	public Interview() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Person getAuthor() {
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
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(ArrayList<Citizen> citizens) {
		this.citizens = citizens;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
