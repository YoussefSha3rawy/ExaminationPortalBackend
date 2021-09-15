package com.shaarawy.examination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaarawy.examination.dao.ExamRepository;
import com.shaarawy.examination.entity.Exam;
import com.shaarawy.examination.entity.Admin;

@Service
public class ExamService {

private ExamRepository examRepository;
	
	@Autowired
	public ExamService(ExamRepository examRepository) {
		this.examRepository = examRepository;
	}

	public List<Exam> findAll() {
		List<Exam> stexs = examRepository.findAll();
		return stexs;
	}
	
	public void addExam(Exam exam) {
		examRepository.save(exam);
	}
	
	public void updateExam(Exam stex) {
		examRepository.save(stex);
	}
	
	public Exam getExam(int id){
		Optional<Exam> exam = examRepository.findById(id);
		if(exam.isPresent())
			return exam.get();
		else
			return null;
	}
}
