package com.crudmvc.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crudmvc.demo.entity.Employee;
import com.crudmvc.demo.service.EmployeeService;


@Controller
public class EmpolyeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public EmpolyeeController(EmployeeService employeeSer)
	{
		super();
		this.employeeService=employeeSer;
	}

	@GetMapping("/addemployee")
	public String createEmployee(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}
	
	@PostMapping("/employee")
	public String SaveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.upsert(employee);
		return "redirect:/employee";
	}
	//	<form th:action="@{/employee/{id} (id=${employee.Id})}" th:object = "${employee}" method="POST">

	@GetMapping("/employee/{id}")
	public String getEmployee(@PathVariable Integer id,Model model) {
		model.addAttribute("employee", employeeService.getById(id));
		return "employee_detail";
	}

	@GetMapping("/employee")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployee());
		return "employees";
	}

	@GetMapping("/employee/update/{id}")
	public String updateEmployee(@PathVariable Integer id,Model model) {
		model.addAttribute("employee", employeeService.getById(id));
		return "update_employee";
	}
	
	@PostMapping("/employee/update/{id}")
	public String updateEmployee(@PathVariable Integer id,
			@ModelAttribute("employee") Employee employee,
			Model model) {
		
		// get student from database by id
		Employee existingEmployee = employeeService.getById(id);
		existingEmployee.setId(id);
		existingEmployee.setName(employee.getName());
		existingEmployee.setAge(employee.getAge());
		
		// save updated student object
		employeeService.upsert(existingEmployee);
		return "redirect:/employee";
	}

	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteById(id);
		return "redirect:/employee";
	}

}

