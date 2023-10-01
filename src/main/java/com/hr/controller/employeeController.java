package com.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.Employee;
import com.hr.service.employeeService;

@RestController
@RequestMapping("/employee")
public class employeeController {

	@Autowired
	private employeeService service;

	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
