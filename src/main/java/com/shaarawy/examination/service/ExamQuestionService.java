package com.shaarawy.examination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaarawy.examination.dao.QuestionRepository;
import com.shaarawy.examination.entity.Question;

@Service
public class ExamQuestionService {

	private QuestionRepository questionRepository;

	@Autowired
	public ExamQuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public List<Question> findAll(){
		return questionRepository.findAll();
	}
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}
	public void answerQuestion(Question question) {
		questionRepository.save(question);
	}
	public List<Question> getExamQuestions(int examID){
		return questionRepository.getExamQuestions(examID);
	}
	
}
