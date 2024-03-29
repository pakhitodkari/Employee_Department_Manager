package com.pv.service;

import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pv.entity.Department;
import com.pv.entity.DeptCount;
import com.pv.entity.Employee;
import com.pv.exception.DepartmentNotPresentException;
import com.pv.exception.EmployeeNotPresentException;
import com.pv.repository.DepartmentRepository;
import com.pv.repository.EmployeeRepository;

import jakarta.persistence.Tuple;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	//For getting all employees
	   public List<Employee> getAllEmployees()
	   {
		   
		   return employeeRepository.findAll();
	   }
	   
	 //For getting employee by id
	   public Employee getByEmployeeId(Integer employeeId)
	   {
		   return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotPresentException("Employee is not Present in database"));
	   }
	   
	 //For getting employee count by department name
	   public List<DeptCount> findByDepartmentName()
	   {
//		   Department dept = departmentRepository.findById().get();
//		   
//		   if(dept == null)
//		   {
//			   throw new DepartmentNotPresentException("Department is not Present in database")
//		   }
		  List<Tuple> result =  departmentRepository.findByDepartmentName();
		  
		  List<DeptCount> deptCount = result.stream().map(res -> new DeptCount(res.get(1),res.get(0))).toList();
		  
		  return deptCount;
	   }
	   
	   
	 //For adding single employee
	   public String addEmployee(Employee employee)
	   {
		   employeeRepository.saveAndFlush(employee);
		   return "Employee Added Successfully";
	   }
	    
	   //For adding multiple Employees
	   public String addEmployees(List<Employee> employees)
	   {
		   	   
		   employeeRepository.saveAllAndFlush(employees);
		   return "All Employees are Added Successfully";
	   }
	    
	   //For updating employee
	   public ResponseEntity<Object> updateEmployee(Integer employeeId, Employee employee)
	   {
	      
	       Employee emp = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotPresentException("Employee is not Present in database"));
	       
	       emp.setEmployeeId(employee.getEmployeeId());
	       emp.setEmployeeName(employee.getEmployeeName());
	       emp.setContactNumber(employee.getContactNumber());
	       emp.setEmployeeEmailId(employee.getContactNumber());
	       emp.setEmployeeAddress(employee.getEmployeeAddress());
	       emp.setEmployeeSalary(employee.getEmployeeSalary());
	       emp.setDepartment(employee.getDepartment());
	       
	       employeeRepository.saveAndFlush(emp);
		   return new ResponseEntity<>("Employee Updated Successfully", HttpStatus.OK);
	   }
	   
	   //For deleting employee
	   public ResponseEntity<Object> deleteEmployee(Integer employeeId)
	   {
		   if(!employeeRepository.existsById(employeeId))
	       {
	    	   throw new EmployeeNotPresentException("Employee is not Present in database");
	       }
		   
		   employeeRepository.deleteById(employeeId);
		   
		   return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.ACCEPTED);
	   }
	   
}
