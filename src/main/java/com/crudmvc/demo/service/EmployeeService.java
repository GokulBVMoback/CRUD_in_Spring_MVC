package com.crudmvc.demo.service;

import java.util.List;

import com.crudmvc.demo.entity.Employee;

public interface EmployeeService {
	
	public String upsert(Employee course);

	public Employee getById(Integer id);

	public List<Employee> getAllEmployee();

	public String deleteById(Integer id);

}
