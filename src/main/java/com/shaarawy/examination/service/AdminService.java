package com.shaarawy.examination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaarawy.examination.dao.AdminRepository;
import com.shaarawy.examination.entity.Admin;

@Service
public class AdminService {

private AdminRepository adminRepository;
	
	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	public List<Admin> findAll() {
		List<Admin> stexs = adminRepository.findAll();
		return stexs;
	}
	
	public void addAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	public void updateAdmin(Admin stex) {
		adminRepository.save(stex);
	}
	
	public Admin getAdmin(String username){
		Optional<Admin> admin = adminRepository.findById(username);
		if(admin.isPresent())
			return admin.get();
		else
			return null;
	}
}
