package com.springdemo.entities.dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entities.Employee;

@Repository

public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	 
	
	private Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName());
	
	@Transactional
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();

		logger.info("Saving employee to the database" + employee.toString());
		currentSession.save(employee);
		
		
		
	}

	
}
