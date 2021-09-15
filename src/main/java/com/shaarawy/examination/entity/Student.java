package com.shaarawy.examination.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = "Students", query = "from Student where (?1 is NULL or username = ?1) and (?2 is NULL or email = ?2) and "
		+ "(?3 is NULL or firstname = ?3) and (?4 is NULL or lastname = ?4) and (?5 is NULL or department = TO_NUMBER(?5))"
		+ " and (?6 is NULL or degree = ?6)")
@Table(name = "students")
public class Student extends User{
	@ManyToOne
	private Department department;
	@Column(name = "degree")
	private String degree;
	@ManyToMany
	private Collection<Course> courses = new ArrayList<Course>();
	@OneToMany(mappedBy = "student") @JsonIgnore
    private Collection<StudentExam> studentExams;

	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	public Collection<StudentExam> getStudentExams() {
		return studentExams;
	}

	public void setStudentExams(Collection<StudentExam> studentExams) {
		this.studentExams = studentExams;
	}

	@Override
	public String toString() {
		return "Student [department=" + department.getDepartmentID() + ", degree=" + degree + ", courses=" + courses + ", studentExams="
				+ studentExams + "]";
	}
	
	public Student(String username, String email, String firstname, String lastname, String password,
			Department department, String degree, Collection<Course> courses, Collection<StudentExam> studentExams) {
		super(username, email, firstname, lastname, password);
		this.department = department;
		this.degree = degree;
		this.courses = courses;
		this.studentExams = studentExams;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
