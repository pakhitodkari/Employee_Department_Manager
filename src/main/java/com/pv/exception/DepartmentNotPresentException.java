package com.pv.exception;

public class DepartmentNotPresentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	   public DepartmentNotPresentException() {}
	   
	   public DepartmentNotPresentException(String msg) {
		   super(msg);
	   }

}
