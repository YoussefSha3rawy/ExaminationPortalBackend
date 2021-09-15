package com.shaarawy.examination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Departments", query = "from Department where (?1 is NULL or departmentID = TO_NUMBER(?1))"
		+ " and (?2 is NULL or departmentName = ?2)")
@Table(name = "departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_GENERATOR")
	@SequenceGenerator(name = "DEPARTMENT_GENERATOR", sequenceName = "DEPARTMENT_GENERATOR", allocationSize = 1, initialValue = 1)
	@Column(name = "department_id")
	private int departmentID;
	@Column(name = "department_name")
	private String departmentName;
	
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


}
