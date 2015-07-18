package org.DAL.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "citizen")
@PrimaryKeyJoinColumn(name = "citizenId", referencedColumnName = "id")
public class Citizen extends Person {
	
	//private long citizenId;
	
	@Column(name = "firstName", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 45)
	private String firstName;
	
	@Column(name = "lastName", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 45)
	private String lastName;
	
	@Column(name = "bonusPoint", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private long bonusPoint;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "InerviewToCitizen", joinColumns = {@JoinColumn(name = "citizenId",
			referencedColumnName = "citizenId")}, inverseJoinColumns = {@JoinColumn(
					name = "interviewId", referencedColumnName = "id")})
	private List<Interview> interviews = new ArrayList<Interview>();
	
	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	public Citizen() {}

	/*public long getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(long citizenId) {
		this.citizenId = citizenId;
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

	public long getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(long bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	

}
