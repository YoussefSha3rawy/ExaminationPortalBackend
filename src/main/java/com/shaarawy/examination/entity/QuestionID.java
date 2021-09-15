package com.shaarawy.examination.entity;

import java.io.Serializable;
import java.util.Objects;

public class QuestionID implements Serializable{
	int questionNumber;
	int exam;
	@Override
	public int hashCode() {
		return Objects.hash(exam, questionNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof QuestionID))
			return false;
		QuestionID other = (QuestionID) obj;
		return Objects.equals(exam, other.exam) && questionNumber == other.questionNumber;
	}
	
	

}