package com.pv.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Auditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;

	@NotNull(message = "Name is Required")
	@Pattern(regexp = "^[aA-zZ ]*", message = "Only alphabets are allowed.")
	private String employeeName;


	@NotNull(message = "Email ID is required")
	@Email(message = "Invalid Email ID")
	private String employeeEmailId;
	
	@Length(max = 10, min = 10, message = "Contact number should be 10 digit")
	private String contactNumber;
	
	@NotNull(message = "Address is required")
	private String employeeAddress;
	
	@NotNull(message = "Salary ID is required")
	private Integer employeeSalary;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Department> department;

}
