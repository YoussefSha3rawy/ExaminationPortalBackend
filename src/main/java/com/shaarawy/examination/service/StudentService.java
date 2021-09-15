package com.shaarawy.examination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaarawy.examination.dao.StudentRepository;
import com.shaarawy.examination.entity.Student;

@Service
public class StudentService {

private StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> findAll() {
		List<Student> stexs = studentRepository.findAll();
		return stexs;
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void updateStudent(Student stex) {
		studentRepository.save(stex);
	}
	
	public Student getStudent(String username){
		Optional<Student> student = studentRepository.findById(username);
		if(student.isPresent())
			return student.get();
		else
			return null;
	}
}
