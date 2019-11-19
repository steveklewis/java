package com.steveklewis.springreact;

import org.springframework.data.repository.CrudRepository;

import com.steveklewis.springreact.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
