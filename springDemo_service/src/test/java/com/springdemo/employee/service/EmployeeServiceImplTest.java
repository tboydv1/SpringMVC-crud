/**
 * 
 */
package com.springdemo.employee.service;

import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdemo.entities.Employee;
import com.springdemo.entities.dao.EmployeeDao;

/**
 * @author user
 *
 */
@ContextConfiguration("classpath:/springDemo-service-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	@Mock
	private EmployeeService employeeService;
	
	@Before
	public void setUp() throws Exception {
		
		employeeService = mock(EmployeeService.class);
	}

	@Test
	public void employeeExistsTest() {
		assertNotNull(EmployeeService.class);
	}
	
	@Test
	public void addEmployeeTest() {
		
		
		Employee employee = new Employee("Peter","Brand","peter@gmail.com");
		
		doNothing().when(employeeService).addEmployee(isA(Employee.class));
		employeeService.addEmployee(employee);
		
		verify(employeeService, times(1)).addEmployee(employee);
	}

}
