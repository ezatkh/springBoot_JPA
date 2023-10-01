package com.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.entity.Employee;
import com.hr.repository.employeeRepo;

@Service
public class employeeService {
	@Autowired
	private employeeRepo repo;

	public Employee findById(Long id) {
		return repo.findById(id).orElseThrow();
	}

}
