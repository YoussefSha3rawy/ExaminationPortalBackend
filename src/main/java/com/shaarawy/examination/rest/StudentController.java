package com.shaarawy.examination.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaarawy.examination.entity.Student;
import com.shaarawy.examination.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping()
	public List<Student> getStudents(){
		return studentService.findAll();
	}

	@GetMapping("/{student_id}")
	public ResponseEntity<Object> getStudent(@PathVariable String student_id){
		Student student = studentService.getStudent(student_id);
		if (student == null) {
			return new ResponseEntity("Incorrect username", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity(student, HttpStatus.OK);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> getStudent(@RequestBody User user){
		Student student = studentService.getStudent(user.username);
		if (student == null) {
			return new ResponseEntity("Incorrect username/password", HttpStatus.NOT_FOUND);
		}
		else {
			if(student.getPassword().equals(user.password)) {
				return new ResponseEntity(student, HttpStatus.OK);
			}
			else {
				return new ResponseEntity("Incorrect useername/password", HttpStatus.NOT_FOUND);
			}
		}
	}
	
	@PostMapping()
	public void addStudent(@RequestBody Student stex) {
		studentService.addStudent(stex);
	}
	
	@PutMapping()
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
	}
}

class User{
	String username;
	String password;
	public User() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
