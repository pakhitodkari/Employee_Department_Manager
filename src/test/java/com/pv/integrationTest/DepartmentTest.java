package com.pv.integrationTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.pv.entity.Department;
import com.pv.entity.Employee;
import com.pv.repository.DepartmentRepository;


@SpringBootTest
@AutoConfigureMockMvc
class DepartmentTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Test
	void shouldCreateDeparment() throws Exception
	{
		
		Department department = getDepartment();
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/dept/addDepartment")
				.contentType(MediaType.APPLICATION_JSON)
				.content(department.toString()))
				.andExpectAll(status().isCreated());
	}
	
	private Department getDepartment() {
		
		return new Department("Manager",new Employee());
		
	}
	
	@Test
	void getAllDepartments() throws Exception
	{
		
		List<Department> departments =  Stream.of(new Department("Manager",new Employee())).collect(Collectors.toList());
		
		departmentRepository.saveAll(departments);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/dept/department")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
			
		
		assertThat(result).isNotNull();
		
	}


}
