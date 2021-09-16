package com.shaarawy.examination.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = "Courses", query = "from Course where (?1 is NULL or courseID = TO_NUMBER(?1))"
		+ " and (?2 is NULL or departmentID = TO_NUMBER(?2)) and (?3 is NULL or courseName = ?3)")
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_GENERATOR")
	@SequenceGenerator(name = "COURSE_GENERATOR", sequenceName = "COURSE_GENERATOR", allocationSize = 1, initialValue = 1)	
	@Column(name = "course_id")
	private int courseID;
	@Column(name = "course_name")
	private String courseName;
	@ManyToMany(mappedBy = "courses") @JsonIgnore
	private Collection<Student> students = new ArrayList<Student>();
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Collection<Student> getStudents() {
		return students;
	}
	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	
	public Course() {
		
	}
	
	public Course(int courseID, String courseName, Collection<Student> students) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName
				+ ", students=" + students + "]";
	}
}
