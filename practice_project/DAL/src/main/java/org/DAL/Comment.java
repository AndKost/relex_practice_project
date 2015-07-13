package org.DAL;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {
	
	public Comment() {
		
	}
	
	private int id;
	private String text;
	private Date date;
	private int numberOfVotes;
	private User author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Interview getInterview() {
		return interview;
	}
	public void setInterview(Interview interview) {
		this.interview = interview;
	}
	private Interview interview;
}
