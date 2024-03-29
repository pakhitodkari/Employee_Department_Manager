package com.pv.exception;

public class EmployeeNotPresentException extends RuntimeException{

	   
		private static final long serialVersionUID = 1L;

	   public EmployeeNotPresentException() {}
	   
	   public EmployeeNotPresentException(String msg) {
		   super(msg);
	   }
}
