package com.springdemo.entities.dao.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.springdemo.db.DbConnectionManagerTest;
import com.springdemo.entities.Employee;
import com.springdemo.entities.dao.EmployeeDao;


@ContextConfiguration(locations="classpath:/springDemo-data-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {

	private Logger logger = Logger.getLogger(DbConnectionManagerTest.class.getName());
	
	
	@Autowired
	private EmployeeDao employeeDaoImpl;
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
//	@Autowired
//	private SessionFactory sessionFactory;
//	
	@Test
	public void dbManagerClassesInitializedTest() {
		
		assertNotNull(employeeDaoImpl);
		assertNotNull(dataSource);
//		assertNotNull(sessionFactory);
	}
	
	@Test
	public void addEmployeeToDatabaseTest() {
		
	try {	
			logger.info("Creating new employee object");
			logger.info("Creating new employee object");
			Employee tempEmployee = new Employee("John", "Paulina", "john@gmail.com");
			
			logger.info("Storing employee to the database");
			employeeDaoImpl.addEmployee(tempEmployee);
			
			logger.info("Successfully saving employee to the databsase");
			
	}
	catch(Exception e) {
		
		e.printStackTrace();
		logger.warning("Error saving employee to the dataabse");
	}
	
		
		
	}
	
	
	@Before
	public void setUp() throws Exception {
	}

	

}
