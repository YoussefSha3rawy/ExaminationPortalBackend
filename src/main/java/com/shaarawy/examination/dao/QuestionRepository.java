package com.shaarawy.examination.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shaarawy.examination.entity.Question;
import com.shaarawy.examination.entity.QuestionID;

@CrossOrigin
public interface QuestionRepository extends JpaRepository<Question, QuestionID> {

	@Query(value = "SELECT * from exam_questions where exam_id = ?1", nativeQuery=true)
	public List<Question> getExamQuestions(int examID);
}
