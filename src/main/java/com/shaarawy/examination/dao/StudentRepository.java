package com.shaarawy.examination.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shaarawy.examination.entity.Course;
import com.shaarawy.examination.entity.Student;
import com.shaarawy.examination.entity.Admin;

@CrossOrigin
public interface StudentRepository extends JpaRepository<Student, String> {

}
