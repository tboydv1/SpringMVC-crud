package com.springdemo.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.entities.Employee;
import com.springdemo.entities.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDaoImpl;
	
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.addEmployee(employee);
		
			
	}

}
