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

	public Employee insert(Employee e) {
		return repo.save(e);
	}

	public Employee update(Employee e) {
		Employee current = repo.findById(e.getId()).get();
		current.setName(e.getName());
		current.setSalary(e.getSalary());
		current.setDep(e.getDep());
		return repo.save(current);
	}
}
