package com.springdemo.contoller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springdemo.employee.service.EmployeeService;
import com.springdemo.entities.Employee;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeServiceImpl;
	
	
	
	@PostMapping("/employee")
	public String addEmployee(@ModelAttribute("employee") Employee tempEmployee ) {
		
		employeeServiceImpl.addEmployee(tempEmployee);
		
		return "employee-list";
		
	}
	
	
}
