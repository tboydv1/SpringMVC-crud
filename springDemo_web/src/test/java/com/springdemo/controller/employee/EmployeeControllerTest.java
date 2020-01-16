package com.springdemo.controller.employee;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springdemo.employee.service.EmployeeService;
import com.springdemo.entities.Employee;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-mvc-crud-demo-servlet.xml")
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private EmployeeService employeeServiceImpl;
	
	@Autowired
	WebApplicationContext wac;


	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
		
	}
	
	
	@Test
	public void addEmployee() throws Exception {
		
		
		Employee theEmployee = new Employee("Micheal", "husborn", "mike@gmail.com");
		
		doNothing().when(employeeServiceImpl).addEmployee(isA(Employee.class));
		
		ObjectMapper obj = new ObjectMapper();
		
		String jsonObj = obj.writeValueAsString(theEmployee);
		
		System.out.println(jsonObj);
		
		mockMvc.perform(post("/addEmployee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonObj).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		
	}
	
	
	@Test
	public void test() {
		
		assertNotNull(employeeServiceImpl);
	}

}
