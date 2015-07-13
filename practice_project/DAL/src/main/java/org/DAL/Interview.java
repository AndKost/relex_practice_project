package org.DAL;

public class Interview {
	private int id;
	private User author;
	private Date startDate;
	private Date finishDate;
	private ArrayList<Comment> comments;
	private ArrayList<Citizen> citizens;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
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
