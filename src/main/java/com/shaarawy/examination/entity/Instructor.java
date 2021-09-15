package com.shaarawy.examination.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Instructors", query = "from Instructor where (?1 is NULL or username = ?1) and "
		+ "(?2 is NULL or email = ?2) and "
		+ "(?3 is NULL or firstname = ?3) and (?4 is NULL or lastname = ?4)")
@Table(name = "instructors")
public class Instructor extends User{

	public Instructor(String username, String email, String firstname, String lastname, String password) {
		super(username, email, firstname, lastname, password);
		// TODO Auto-generated constructor stub
	}

}
