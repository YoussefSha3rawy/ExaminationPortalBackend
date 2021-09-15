package com.shaarawy.examination.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = "Exams", query = "from Exam where (?1 is NULL or examID = TO_NUMBER(?1))"
		+ " and (?2 is NULL or examDate = ?2) and (?3 is NULL or StudentID = ?3)"
		+ " and (?4 is NULL or courseID = TO_NUMBER(?4))")
@Table(name = "exams")
public class Exam {
	@Id 	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_GENERATOR")
	@SequenceGenerator(name = "EXAM_GENERATOR", sequenceName = "EXAM_GENERATOR", allocationSize = 1, initialValue = 1)
	@Column(name = "exam_id")
	private Integer examID;
	@Column(name = "duration_in_mins")
	private int allottedTime;
	@Column(name = "exam_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date examDate;
	@ManyToOne
	private Course course;
	@OneToMany(mappedBy = "exam") @JsonIgnore
    private Collection<StudentExam> studentExams;
	
	
	public Integer getExamID() {
		return examID;
	}


	public void setExamID(Integer examID) {
		this.examID = examID;
	}


	public int getAllottedTime() {
		return allottedTime;
	}


	public void setAllottedTime(int allottedTime) {
		this.allottedTime = allottedTime;
	}


	public Date getExamDate() {
		return examDate;
	}


	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Collection<StudentExam> getStudentExams() {
		return studentExams;
	}


	public void setStudentExams(Collection<StudentExam> studentExams) {
		this.studentExams = studentExams;
	}


	@Override
	public String toString() {
		return "Exam [examID=" + examID + ", allottedTime=" + allottedTime + ", examDate=" + examDate + ", course=" + course + ", studentExams=" + studentExams + "]";
	}

}
