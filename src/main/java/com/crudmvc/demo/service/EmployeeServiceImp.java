package com.crudmvc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudmvc.demo.entity.Employee;
import com.crudmvc.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public String upsert(Employee course) {
		empRepo.save(course);
		return "success";
	}

	@Override
	public Employee getById(Integer Id) {
		Optional<Employee> findById = empRepo.findById(Id);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if (empRepo.existsById(id))
		{
			empRepo.deleteById(id);
			return "Delete Success";
		} 
		else 
		{
			return "No Record Found";
		}
	}

}
