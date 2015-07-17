package org.DAL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
@PrimaryKeyJoinColumn(name = "adminId", referencedColumnName = "id")
public class Admin extends Person {
	
	//private long adminId;
	@Column(name = "firstName", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 45)
	private String firstName;
	
	@Column(name = "lastName", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 45)
	private String lastName;
	
	@Column(name = "phone", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 20)
	private String phone;
	
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Interview> interviews = new ArrayList<Interview>();
	
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<News> news = new ArrayList<News>();
	
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Report> reports = new ArrayList<Report>();
	
	public Admin() {}
	
	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	/*public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}