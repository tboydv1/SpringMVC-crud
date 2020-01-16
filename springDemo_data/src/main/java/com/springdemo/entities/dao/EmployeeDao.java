package com.springdemo.entities.dao;

import java.util.List;

import com.springdemo.entities.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void updateEmployee(Employee theEmployee);
	
	public void deleteEmployee(int employeeId);
	
}
