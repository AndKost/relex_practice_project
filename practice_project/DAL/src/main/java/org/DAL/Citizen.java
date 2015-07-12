package org.DAL;

import java.util.Date;

public class Citizen extends User {
	
	private long citizenId;
	private String firstName;
	private String lastName;
	private Date registrationDate;
	private long bonusPoint;
	private List<Interview> interviews;
	
	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	public Citizen() {}

	public long getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(long citizenId) {
		this.citizenId = citizenId;
	}

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

	public long getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(long bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	

}
