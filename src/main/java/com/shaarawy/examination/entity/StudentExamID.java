package com.shaarawy.examination.entity;

import java.io.Serializable;
import java.util.Objects;

public class StudentExamID implements Serializable {
    private String student;
    private Integer exam;
    
	
	public StudentExamID() {
	}
	public StudentExamID(String student, Integer exam) {
		this.student = student;
		this.exam = exam;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public Integer getExam() {
		return exam;
	}
	public void setExam(Integer exam) {
		this.exam = exam;
	}
	@Override
	public int hashCode() {
		return Objects.hash(exam, student);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentExamID other = (StudentExamID) obj;
		return Objects.equals(exam, other.exam) && Objects.equals(student, other.student);
	}
	

}
