package org.DAL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "adminId", referencedColumnName = "id")
public class Admin extends User {
	
	//private long adminId;
	@Column(name = "firstName", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 45)
	private String firstName;
	
	@Column(name = "lastName", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 45)
	private String lastName;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "registrationDate", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 45)
	private Date registrationDate;
	
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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