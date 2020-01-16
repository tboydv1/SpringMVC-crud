package com.springdemo.employee.service;

import java.util.List;

import com.springdemo.entities.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	
	public List<Employee> getEmployees();

	public Employee getEmployeeById(int employeeId);

	public void updateEmployee(Employee theEmployee);

	public void deleteEmployee(int employeeId);
}
