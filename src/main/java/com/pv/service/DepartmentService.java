package com.pv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pv.entity.Department;
import com.pv.exception.DepartmentNotPresentException;
import com.pv.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	
	@Autowired
	private DepartmentRepository departmentRepository;

	//For getting all departments
	   public List<Department> getAllDepartments()
	   {
		   
		   return departmentRepository.findAll();
	   }
	   
	 //For getting department by departmentName
	   public Department getByDepartmentName(String departmentName)
	   {
		   return departmentRepository.findById(departmentName).orElseThrow(() -> new DepartmentNotPresentException("Department is not Present in database"));
	   }
	   
	   
	   
	 //For adding  department
	   public String addDepartment(Department department)
	   {
		   departmentRepository.saveAndFlush(department);
		   return "Department Added Successfully";
	   }
	    
	    
	   //For updating department
	   public ResponseEntity<Object> updateDepartment(String departmentName, Department department)
	   {
	      
	       Department dept = departmentRepository.findById(departmentName).orElseThrow(() -> new DepartmentNotPresentException("Department is not Present in database"));
	       
	       dept.setDepartmentName(department.getDepartmentName());
	       dept.setEmployee(department.getEmployee());
	       
	       departmentRepository.saveAndFlush(dept);
		   return new ResponseEntity<>("Department Updated Successfully", HttpStatus.OK);
	   }
	   
	   //For deleting department
	   public ResponseEntity<Object> deleteDepartment(String departmentName)
	   {
		   if(!departmentRepository.existsById(departmentName))
	       {
	    	   throw new DepartmentNotPresentException("Department is not Present in database");
	       }
		   
		   departmentRepository.deleteById(departmentName);
		   
		   return new ResponseEntity<>("Department Deleted Successfully", HttpStatus.ACCEPTED);
	   }
}
