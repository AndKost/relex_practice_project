package org.DAL;

public class User {

	protected long id;
	protected String login;
	protected String email;
	protected String password;
	protected short user_category;
	
	public User() {}

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

	public short getUser_category() {
		return user_category;
	}

	public void setUser_category(short user_category) {
		this.user_category = user_category;
	}
	
}
