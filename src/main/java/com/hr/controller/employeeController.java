package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/")
	public Employee insert(@RequestBody Employee e) {
		return service.insert(e);
	}

	@PutMapping("/")
	public Employee update(@RequestBody Employee e) {
		return service.update(e);
	}

	@GetMapping("/department/{depId}")
	public List<Employee> findByDep_Id(@PathVariable Long depId) {
		return service.findByDep_Id(depId);
	}

	@GetMapping("/name/empList")
	public List<Employee> findByNameContaining(@RequestParam String empName) {
		return service.findByNameContaining(empName);
	}

	@GetMapping("/salary/{salary}")
	public double findBySalary(@PathVariable double salary) {
		return service.findBySalary(salary);
	}

//	@GetMapping("/name/emp-dep/count")
//	public Long countByNameContainingAndDepartmentNameContaining(@RequestParam String empName,
//			@RequestParam String depName) {
//		return service.countByNameContainingAndDepartmentNameContaining(empName, depName);
//	}

}
