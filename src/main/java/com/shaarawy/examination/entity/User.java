package com.shaarawy.examination.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Users", query = "from User where (?1 is NULL or username = ?1) and (?2 is NULL or email = ?2) and "
		+ "(?3 is NULL or firstname = ?3) and (?4 is NULL or lastname = ?4)")
@Table(name = "users")
public class User {
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "password")
	private String password;
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + "]";
	}
	public User(String username, String email, String firstname, String lastname, String password) {
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
}
