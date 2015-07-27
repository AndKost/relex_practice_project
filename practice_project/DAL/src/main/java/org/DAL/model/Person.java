package org.DAL.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
	@SequenceGenerator(name = "PERSON_SEQ", sequenceName = "person_seq", 
		initialValue = 1, allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false, insertable = true, 
	updatable = true)
	protected long id;
	
	@Column(name = "login", unique = true, nullable = false, insertable = true, 
			updatable = true, length = 45)
	protected String login;
	
	@Column(name = "email", unique = true, nullable = false, insertable = true, 
			updatable = true, length = 45)
	protected String email;
	
	@Column(name = "password", unique = false, nullable = false, insertable = true, 
			updatable = true, length = 70)
	protected String password;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "registrationDate", unique = false, nullable = false, insertable = true, 
			updatable = true)
	private Date registrationDate;
	
	//protected short user_category;
	
	public Person() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/*public short getUser_category() {
		return user_category;
	}

	public void setUser_category(short user_category) {
		this.user_category = user_category;
	}*/
	
}
