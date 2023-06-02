package com.crudmvc.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudmvc.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Serializable> {

}
