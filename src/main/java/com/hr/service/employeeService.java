package com.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.entity.Employee;
import com.hr.repository.employeeRepo;

@Service
public class employeeService {
	@Autowired
	private employeeRepo repo;
	@Autowired
	private departmentService depService;

	public Employee findById(Long id) {
		return repo.findById(id).orElseThrow();
	}

	public Employee insert(Employee e) {
		if (e.getDep() != null && e.getDep().getId() != null) {
			e.setDep(depService.findById(e.getDep().getId()));
		}
		return repo.save(e);
	}

	public Employee update(Employee e) {
		Employee current = repo.findById(e.getId()).get();
		current.setName(e.getName());
		current.setSalary(e.getSalary());
		current.setDep(e.getDep());
		return repo.save(current);
	}

	public List<Employee> findByDep_Id(long depId) {
		return repo.findByDep_Id(depId);
	}

	public List<Employee> findByNameContaining(String empName) {
		return repo.findByNameContaining(empName);
	}

	public double countBySalary(double salary) {
		return repo.countBySalary(salary);
	}

	public List<Employee> findBySalary(double salary) {
		return repo.findBySalary(salary);
	}

//	public Long countByNameContainingAndDepartmentNameContaining(String empName, String depName) {
//		return repo.countByNameContainingAndDepartmentNameContaining(empName, depName);
//	}
}
