package com.pv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pv.entity.Department;
import com.pv.service.DepartmentService;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/department")
	   public List<Department> getAllDepartments()
	   {
		   return departmentService.getAllDepartments();
	   }
	   
	   @GetMapping("/getDepartment/{deptName}")
	   public Department getByDepartmentName(@PathVariable("deptName") String departmentName)
	   {
		   return departmentService.getByDepartmentName(departmentName);
	   }
	   
	   
	   @PostMapping("/addDepartment")
	   public String addDepartment(@RequestBody Department department)
	   {
		   return departmentService.addDepartment(department);
	   }
	   
	   
	   @PutMapping("/updateDepartment/{deptName}")
	   public ResponseEntity<Object> updateDepartment(@PathVariable("deptName") String departmentName, @RequestBody Department department)
	   {
		   return departmentService.updateDepartment(departmentName, department);
	   }
	   
	   @DeleteMapping("/deleteDepartment/{deptName}")
	   public ResponseEntity<Object> deleteDepartment(@PathVariable("deptName") String departmentName)
	   {
		   return departmentService.deleteDepartment(departmentName);
	   }

}
