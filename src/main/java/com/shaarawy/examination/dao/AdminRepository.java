package com.shaarawy.examination.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shaarawy.examination.entity.Admin;
@CrossOrigin
public interface AdminRepository extends JpaRepository<Admin, String> {

}
