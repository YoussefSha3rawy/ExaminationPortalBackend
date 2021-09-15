package com.shaarawy.examination.entity;

import javax.persistence.*;

@Entity
@IdClass(StudentExamID.class)
@NamedQuery(name = "studentExams", query = "from StudentExam where (?1 is NULL or exam = TO_NUMBER(?1))"
		+ " and (?2 is NULL or studentID = ?2)")
@Table(name = "student_exams")
public class StudentExam {
	@Id @ManyToOne @JoinColumn(name = "student_id", referencedColumnName = "username")
	private Student student;
    @Id @ManyToOne @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private Exam exam;
    @Column(name = "result")
    private int result;

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "StudentExam [student=" + student + ", exam=" + exam + ", result=" + result + "]";
	}
}
