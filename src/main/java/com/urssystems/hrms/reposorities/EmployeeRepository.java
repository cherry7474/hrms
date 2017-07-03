package com.urssystems.hrms.reposorities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urssystems.hrms.pojos.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    

}