/**
 * 
 */
package com.springdemo.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author oluwatobi
 *
 */
@ContextConfiguration("classpath:/springDemo-data-context.xml")
@RunWith(SpringRunner.class)
public class DbConnectionManagerTest {
	
	private Logger logger = Logger.getLogger(DbConnectionManagerTest.class.getName());
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	
	@Test
	public void dataSourceInitializedTest() {
		
		assertNotNull(dataSource);
	}

	@Test
	public void dbConnectionManagerExistTest() {
		
		String user = "springdemouser";
		String password = "spring_Demo1";
		String jdbcUrl = "jdbc:mysql://localhost:3306/springDemoDB?useSSL=false&serverTimezone=UTC";
	
		try {
			
			
			logger.info("Getting connection to the database");
			
			Connection mycon = DriverManager.getConnection(jdbcUrl, user, password);
			
			logger.info("Connection to the database successful" + jdbcUrl);
			
			assertNotNull(mycon);
			
		}
		catch(SQLException e) {
			
			logger.warning("Error connecting to the database");
		}
		
		
	}

}
