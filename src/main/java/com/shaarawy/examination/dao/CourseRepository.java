package com.shaarawy.examination.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shaarawy.examination.entity.Course;

@CrossOrigin
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
