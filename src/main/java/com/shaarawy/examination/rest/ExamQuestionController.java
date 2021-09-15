package com.shaarawy.examination.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shaarawy.examination.entity.Question;
import com.shaarawy.examination.service.ExamQuestionService;

@RestController
public class ExamQuestionController {
	
	private ExamQuestionService questionService;

	@Autowired
	public ExamQuestionController(ExamQuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping("/examQuestions")
	public List<Question> findAll(){
		return questionService.findAll();
	}
	
	@GetMapping("examQuestions/{examID}")
	public List<Question> getExamQuestions(@PathVariable int examID){
		return questionService.getExamQuestions(examID);
	}
	
	@PostMapping("examQuestions")
	public List<Question> addQuestion(@RequestBody Question question) {
		questionService.addQuestion(question);
		return questionService.getExamQuestions(question.getExam().getExamID());
	}
	
	@PutMapping
	public void answerQuestion(Question question) {
		questionService.answerQuestion(question);
	}

}
