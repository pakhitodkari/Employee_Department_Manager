package com.pv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pv.exception.DepartmentNotPresentException;
import com.pv.exception.EmployeeNotPresentException;

@ControllerAdvice
public class ExceptionController 
{

	@ExceptionHandler(value = EmployeeNotPresentException.class)
	   public ResponseEntity<Object> employeeNotPresentException(Exception e)
	   {
		   return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	   }
	
	@ExceptionHandler(value = DepartmentNotPresentException.class)
	   public ResponseEntity<Object> departmentNotPresentException(Exception e)
	   {
		   return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	   }
	   
}
