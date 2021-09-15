package com.shaarawy.examination.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shaarawy.examination.entity.Exam;

@CrossOrigin
@RepositoryRestResource(excerptProjection = CourseProjection.class)
public interface ExamRepository extends JpaRepository<Exam, Integer> {

}
