package com.pv.unitTest.department;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pv.controller.DepartmentController;
import com.pv.entity.Department;
import com.pv.entity.Employee;
import com.pv.service.DepartmentService;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestDepartment {

	@InjectMocks
	private DepartmentController departmentController;
	
	@Mock
	private DepartmentService departmentService;
	
	@Test
	@DisplayName(value = "Check Adding department")
	 void testAddingValidDepartment()
	{
		
		Employee employee = new Employee(1,"Prachi","prachitodkari98@gmail.com","9860221265","abc",55000,new ArrayList<Department>());
		
		Department dept = new Department("Manager",employee);
		
		when(departmentService.addDepartment(dept)).thenReturn("Department Added Successfully");
		
		assertThat(departmentController.addDepartment(dept)).isEqualTo("Department Added Successfully");
		
	}
	
	@Test
	@DisplayName(value = "Check getting all the departments")
	 void testGetAllDepartments()
	{
		
		when(departmentService.getAllDepartments()).thenReturn(new ArrayList<Department>());
		
		assertThat(departmentController.getAllDepartments()).isEqualTo(new ArrayList<Department>());
		
		
	}
	
	@Test
	@DisplayName(value = "Get department for given name")
	 void testGetDepartmentById() {
		
		
		when(departmentService.getByDepartmentName("Manager")).thenReturn(new Department());
		
		Department dept = departmentController.getByDepartmentName("Manager");
		
		assertThat(dept).isNotNull();
	}
	
	@Test
	@DisplayName(value = "Update valid Department")
	 void testUpdateValidDepartment()
	{
		
        Employee employee = new Employee(1,"Prachi","prachitodkari98@gmail.com","9860221265","abc",55000,new ArrayList<Department>());
		
		Department dept = new Department("Manager",employee);

		
		when(departmentService.updateDepartment("Manager", dept)).thenReturn(new ResponseEntity<Object>("Department Updated Successfully", HttpStatus.OK));
		
		ResponseEntity<Object> response = departmentController.updateDepartment("Manager", dept);
		
		assertThat(response.getBody()).isEqualTo("Department Updated Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	@DisplayName(value = "Delete valid Department")
	 void testDeleteValidDepartment()
	{
		
		when(departmentService.deleteDepartment("Manager")).thenReturn(new ResponseEntity<Object>("Seller is Deleted Successfully", HttpStatus.OK));
		
		ResponseEntity<Object> response = departmentController.deleteDepartment("Manager");
		
		assertThat(response.getBody()).isEqualTo("Department Deleted Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
	}


}
