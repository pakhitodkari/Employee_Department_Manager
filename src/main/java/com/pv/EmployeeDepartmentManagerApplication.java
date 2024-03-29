package com.pv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeDepartmentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDepartmentManagerApplication.class, args);
	}

}
