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

import com.pv.entity.DeptCount;
import com.pv.entity.Employee;
import com.pv.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	 @GetMapping("/employees")
	   public List<Employee> getAllEmployees()
	   {
		   return employeeService.getAllEmployees();
	   }
	   
	   @GetMapping("/getEmployee/{id}")
	   public Employee getByEmployeeId(@PathVariable("id") Integer employeeId)
	   {
		   return employeeService.getByEmployeeId(employeeId);
	   }

	   @GetMapping("/getCount")
	   public List<DeptCount> getEmployeeCount()
	   {
		   return employeeService.findByDepartmentName();
	   }
	   
	   
	   @PostMapping("/addEmployee")
	   public String addEmployee(@RequestBody Employee employee)
	   {
		   return employeeService.addEmployee(employee);
	   }
	   
	   @PostMapping("/addEmployees")
	   public String addEmployees(@RequestBody List<Employee> employees)
	   {
		   return employeeService.addEmployees(employees);
	   }
	   
	   @PutMapping("/updateEmployee/{id}")
	   public ResponseEntity<Object> updateEmployee(@PathVariable("id") Integer employeeId, @RequestBody Employee employee)
	   {
		   return employeeService.updateEmployee(employeeId, employee);
	   }
	   
	   @DeleteMapping("/deleteEmployee/{id}")
	   public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer employeeId)
	   {
		   return employeeService.deleteEmployee(employeeId);
	   }
	    
}
