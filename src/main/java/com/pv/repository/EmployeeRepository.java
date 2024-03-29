package com.pv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pv.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
