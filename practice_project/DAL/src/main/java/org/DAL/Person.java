package org.DAL;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROGECT_SEQ")
	@SequenceGenerator(name = "PERSON_SEQ", sequenceName = "project_seq", 
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
			updatable = true, length = 45)
	protected String password;
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

	/*public short getUser_category() {
		return user_category;
	}

	public void setUser_category(short user_category) {
		this.user_category = user_category;
	}*/
	
}
