package com.shaarawy.examination.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shaarawy.examination.dao.StudentExamRepository;
import com.shaarawy.examination.dao.StudentRepository;
import com.shaarawy.examination.entity.Course;
import com.shaarawy.examination.entity.Exam;
import com.shaarawy.examination.entity.Student;
import com.shaarawy.examination.entity.StudentExam;
import com.shaarawy.examination.entity.StudentExamID;

@Service
public class StudentExamService {

	private StudentExamRepository studentExamRepository;
	
	@Autowired
	public StudentExamService(StudentExamRepository studentExamRepository) {
		this.studentExamRepository = studentExamRepository;
	}

	public List<StudentExam> findAll() {
		List<StudentExam> stexs = studentExamRepository.findAll();
		return stexs;
	}
	
	public void registerExam(StudentExam stex) {
		Optional<StudentExam> opt = studentExamRepository.findById(new StudentExamID(stex.getStudent().getUsername(),stex.getExam().getExamID()));
		if(opt.isPresent()) {
			throw new Error("Student already registered");
		}
		else
			studentExamRepository.save(stex);
	}
	
	public void addResult(StudentExam stex) {
		studentExamRepository.save(stex);
	}
	
	public List<StudentExam> getStudentExams(String student_id){
		return studentExamRepository.getStudentExams(student_id);
	}
}
