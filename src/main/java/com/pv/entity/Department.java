package com.pv.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department extends Auditable{

	@Id
	private String departmentName;
	
	@ManyToOne
	@JsonBackReference
	private Employee employee;

}
