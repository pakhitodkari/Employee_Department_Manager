package com.pv.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeptCount {
	

	private String deptName;
	
	private Object count;
	
	public DeptCount(Object obj1, Object obj2)
	{
		this.deptName = new String((String) obj1);
		this.count = obj2;
		
	}
	
	
}
