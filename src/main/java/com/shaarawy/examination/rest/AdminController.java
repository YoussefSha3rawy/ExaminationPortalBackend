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

import com.shaarawy.examination.entity.Admin;
import com.shaarawy.examination.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {

private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping()
	public List<Admin> getAdmins(){
		return adminService.findAll();
	}

	@GetMapping("/{admin_id}")
	public ResponseEntity<Object> getAdmin(@PathVariable String admin_id){
		Admin admin = adminService.getAdmin(admin_id);
		if (admin == null) {
			return new ResponseEntity("Incorrect username", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity(admin, HttpStatus.OK);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> getAdmin(@RequestBody User user){
		Admin admin = adminService.getAdmin(user.username);
		if (admin == null) {
			return new ResponseEntity("Incorrect username/password", HttpStatus.NOT_FOUND);
		}
		else {
			if(admin.getPassword().equals(user.password)) {
				return new ResponseEntity(admin, HttpStatus.OK);
			}
			else {
				return new ResponseEntity("Incorrect username/password", HttpStatus.NOT_FOUND);
			}
		}
	}
	
	@PostMapping()
	public void addAdmin(@RequestBody Admin stex) {
		adminService.addAdmin(stex);
	}
	
	@PutMapping()
	public void updateAdmin(@RequestBody Admin admin) {
		adminService.updateAdmin(admin);
	}
}
