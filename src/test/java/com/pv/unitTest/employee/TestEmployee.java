package com.pv.unitTest.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pv.controller.EmployeeController;
import com.pv.entity.Department;
import com.pv.entity.Employee;
import com.pv.service.EmployeeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestEmployee {
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Mock
	private EmployeeService employeeService;

	
	@Test
	@DisplayName(value = "Check Adding employees")
	 void testAddingValidEmployee()
	{
		List<Department> department = new ArrayList<Department>();
		
		Employee employee = new Employee(1,"Prachi","prachitodkari98@gmail.com","9860221265","abc",55000,department);
		
		when(employeeService.addEmployee(employee)).thenReturn("Employee Added Successfully");
		
		assertThat(employeeController.addEmployee(employee)).isEqualTo("Seller is Added Successfully");
		
	}
	
	@Test
	@DisplayName(value = "Check getting all the employees")
	 void testGetAllEmployees()
	{
		
		when(employeeService.getAllEmployees()).thenReturn(new ArrayList<Employee>());
		
		assertThat(employeeController.getAllEmployees()).isEqualTo(new ArrayList<Employee>());
		
		
	}
	
	@Test
	@DisplayName(value = "Get employee for given id")
	 void testGetEmployeeById() {
		
		
		when(employeeService.getByEmployeeId(1)).thenReturn(new Employee());
		
		Employee employee = employeeController.getByEmployeeId(1);
		
		assertThat(employee).isNotNull();
	}
	
	@Test
	@DisplayName(value = "Update valid Employee")
	 void testUpdateValidEmployee()
	{
		List<Department> department = new ArrayList<Department>();
		
		Employee employee = new Employee(1,"Prachi","prachitodkari98@gmail.com","9860221265","abc",55000,department);

		
		when(employeeService.updateEmployee(1, employee)).thenReturn(new ResponseEntity<Object>("Seller is Updated Successfully", HttpStatus.OK));
		
		ResponseEntity<Object> response = employeeController.updateEmployee(1, employee);
		
		assertThat(response.getBody()).isEqualTo("Employee Updated Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	@DisplayName(value = "Delete valid Employee")
	 void testDeleteValidEmployee()
	{
		
		when(employeeService.deleteEmployee(1)).thenReturn(new ResponseEntity<Object>("Employee Deleted Successfully", HttpStatus.ACCEPTED));
		
		ResponseEntity<Object> response = employeeController.deleteEmployee(1);
		
		assertThat(response.getBody()).isEqualTo("Employee Deleted Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
	}

	
}
