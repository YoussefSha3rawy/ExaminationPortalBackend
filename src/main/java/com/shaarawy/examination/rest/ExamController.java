package com.shaarawy.examination.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaarawy.examination.entity.Exam;
import com.shaarawy.examination.service.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamController {

private ExamService examService;
	
	@Autowired
	public ExamController(ExamService examService) {
		this.examService = examService;
	}
	
	@GetMapping()
	public List<Exam> getExams(){
		return examService.findAll();
	}

	@GetMapping("/{exam_id}")
	public Exam getExam(@PathVariable int exam_id){
		return examService.getExam(exam_id);
	}
	
	@PostMapping()
	public void addExam(@RequestBody Exam stex) {
		examService.addExam(stex);
	}
	
	@PutMapping()
	public void updateExam(@RequestBody Exam exam) {
		examService.updateExam(exam);
	}
}
