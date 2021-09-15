package com.shaarawy.examination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@IdClass(QuestionID.class)
@NamedQuery(name = "examQuestions", query = "from Question where (?1 is NULL or examID = TO_NUMBER(?1))"
		+ " and (?2 is NULL or questionNumber = TO_NUMBER(?2))")
@Table(name = "exam_questions")
public class Question {
	@Id
	@Column(name = "question_number")
	private int questionNumber;
	@ManyToOne @Id @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
	private Exam exam;
	@Column(name = "question_type")
	private String questionType;
	@Column(name = "question")
	private String question;
	@Column(name = "option_a")
	private String optionA;
	@Column(name = "option_b")
	private String optionB;
	@Column(name = "option_c")
	private String optionC;
	@Column(name = "option_d")
	private String optionD;
	@Column(name = "option_e")
	private String optionE;
	@Column(name = "option_f")
	private String optionF;
	@Column(name = "answer")
	private String answer;
	@Column(name = "correct_answer")
	private String correctAnswer;
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getOptionE() {
		return optionE;
	}
	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}
	public String getOptionF() {
		return optionF;
	}
	public void setOptionF(String optionF) {
		this.optionF = optionF;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Question() {

	}
	
	public Question(int questionNumber, Exam exam, String questionType, String question, String optionA, String optionB,
			String optionC, String optionD, String optionE, String optionF, String answer, String correctAnswer) {
		this.questionNumber = questionNumber;
		this.exam = exam;
		this.questionType = questionType;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.optionE = optionE;
		this.optionF = optionF;
		this.answer = answer;
		this.correctAnswer = correctAnswer;
	}
	@Override
	public String toString() {
		return "Question [questionNumber=" + questionNumber + ", exam=" + exam + ", questionType=" + questionType
				+ ", question=" + question + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", optionE=" + optionE + ", optionF=" + optionF + ", answer=" + answer
				+ ", correctAnswer=" + correctAnswer + "]";
	}
}