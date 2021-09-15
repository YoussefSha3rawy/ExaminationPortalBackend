package com.shaarawy.examination.dao;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.shaarawy.examination.entity.Course;
import com.shaarawy.examination.entity.Exam;

@Projection(name = "inlineCourse", types = { Exam.class })
public interface CourseProjection {
	int getExamID();
	int getAllottedTime();
	Date getExamDate();
	Course getCourse();
}
