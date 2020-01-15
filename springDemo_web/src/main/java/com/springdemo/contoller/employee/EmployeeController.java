package com.springdemo.contoller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.employee.service.EmployeeService;
import com.springdemo.entities.Employee;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeServiceImpl;
	
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee tempEmployee) {
		

		System.out.println(tempEmployee.getEmail());
		
		employeeServiceImpl.addEmployee(tempEmployee);
		
		return "employee-list";
		
	}
	
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	
	
}
