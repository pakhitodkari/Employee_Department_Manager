package com.pv.integrationTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.pv.entity.Department;
import com.pv.entity.Employee;
import com.pv.repository.EmployeeRepository;


@SpringBootTest
@AutoConfigureMockMvc
class EmployeeTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Test
	void shouldCreateEmployee() throws Exception
	{
		
		Employee employee = getEmployee();
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/emp/addEmployee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(employee.toString()))
				.andExpectAll(status().isCreated());
	}
	
	private Employee getEmployee() {
		
		return new Employee(1,"Prachi","prachitodkari98@gmail.com","9860221265","abc",55000,new ArrayList<Department>());
		
	}
	
	@Test
	void getAllEmployees() throws Exception
	{
		
		List<Employee> employees =  Stream.of(new Employee(1,"Prachi","prachitodkari98@gmail.com","9860221265","abc",55000,new ArrayList<Department>())).collect(Collectors.toList());
		
		employeeRepository.saveAll(employees);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/emp/getEmployees")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
			
		
		assertThat(employees).hasSize(1);
		
	}


}
