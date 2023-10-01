package com.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.department.Department;
import com.hr.repository.departmentRepo;

@Service
public class departmentService {
	@Autowired
	private departmentRepo repo;

	public Department findById(Long id) {
		return repo.findById(id).orElseThrow();
	}

	public Department insert(Department d) {
		return repo.save(d);
	}

	public Department update(Department d) {
		Department current = repo.findById(d.getId()).get();
		current.setName(d.getName());
		return repo.save(current);
	}

}
