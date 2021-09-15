package com.shaarawy.examination.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shaarawy.examination.entity.StudentExam;
import com.shaarawy.examination.entity.StudentExamID;

@CrossOrigin
public interface StudentExamRepository extends JpaRepository<StudentExam, StudentExamID> {

	@Query(value = "Select * from student_exams where student_id=?1", nativeQuery = true)
	public List<StudentExam> getStudentExams(String student_id);
}
