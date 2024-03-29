package com.pv.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pv.entity.Department;
import com.pv.entity.DeptCount;

import jakarta.persistence.Tuple;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{

	@Query(value = "select count(*), department_name from department group by department_name",nativeQuery = true)
	public List<Tuple> findByDepartmentName();
	
}
