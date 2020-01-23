package com.springdemo.controller.employee;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		employeeServiceImpl.addEmployee(theEmployee);
		
		verify(employeeServiceImpl, times(1)).addEmployee(theEmployee);
		
		ObjectMapper obj = new ObjectMapper();
		
		String jsonObj = obj.writeValueAsString(theEmployee);
		
		System.out.println(jsonObj);
		
		mockMvc.perform(post("/employee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonObj)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value("Micheal"))
				.andExpect(jsonPath("lastName").value("husborn"))
				.andExpect(jsonPath("$.email").value("mike@gmail.com"));
		
	}
	
	@Test
	public void getEmployees_fromDatabaseTest() throws Exception {
		
		when(employeeServiceImpl.getEmployees()).thenReturn(new ArrayList<Employee>());
		employeeServiceImpl.getEmployees();
		
		verify(employeeServiceImpl, times(1)).getEmployees();
		
		MvcResult result = mockMvc.perform(get("/employee"))
		       .andExpect(status().isOk())
		       .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//		       .andDo(print())
		       .andReturn();
		
	
		System.out.println(result.getResponse().getContentAsString());
		
		
	}
	
	@Test
	public void fetch_EmployeeById() throws Exception {
		
		when(employeeServiceImpl.getEmployeeById(1)).thenReturn(isA(Employee.class));
		employeeServiceImpl.getEmployeeById(1);
		
		verify(employeeServiceImpl, times(1)).getEmployeeById(1);
		
		MvcResult result = mockMvc.perform(get("/employee/1")
				.requestAttr("employeeId", 1))
				.andExpect(status().isOk())
//				.andExpect(matcher))
				.andExpect(jsonPath("$.firstName").value("John"))
				.andExpect(jsonPath("$.lastName").value("Paulina"))
				.andExpect(jsonPath("$.email").value("john@gmail.com"))
				.andReturn();
	
		System.out.println(result.getResponse().getContentAsString());
	}
	
	
	
	
	
	
	@Test
	public void test() {
		
		assertNotNull(employeeServiceImpl);
	}

}
