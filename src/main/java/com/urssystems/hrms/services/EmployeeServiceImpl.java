package com.urssystems.hrms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urssystems.hrms.pojos.Employee;
import com.urssystems.hrms.reposorities.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmp(Employee e) {
		employeeRepository.save(e);
	}
	
	

}
