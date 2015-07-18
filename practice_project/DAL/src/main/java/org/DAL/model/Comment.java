package org.DAL.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ")
	@SequenceGenerator(name = "COMMENT_SEQ", sequenceName = "comment_seq", 
		initialValue = 1, allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false, insertable = true, 
		updatable = true)
	private long id;
	
	@Column(name = "text", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private String text;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "date", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private Date date;
	
	@Column(name = "numberOfVotes", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private int numberOfVotes;
	
	@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId", referencedColumnName = "id", unique = false, 
		nullable = false, insertable = true, updatable = false)
	private Person author;
	
	@ManyToOne(targetEntity = Interview.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "informId", referencedColumnName = "id", unique = false, 
		nullable = false, insertable = true, updatable = false)
	private Interview interview;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CommentToCitizen", joinColumns = {@JoinColumn(name = "commentId",
			referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(
					name = "citizenId", referencedColumnName = "citizenId")})
	private List<Citizen> interviews = new ArrayList<Citizen>();
	
	@Column(name = "premoderation", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private boolean premoderation;
	
	public Comment() {}
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNumberOfVotes() {
		return numberOfVotes;
	}
	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Person author) {
		this.author = author;
	}
	public Interview getInterview() {
		return interview;
	}
	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public List<Citizen> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Citizen> interviews) {
		this.interviews = interviews;
	}

	public boolean isPremoderation() {
		return premoderation;
	}

	public void setPremoderation(boolean premoderation) {
		this.premoderation = premoderation;
	}
}
