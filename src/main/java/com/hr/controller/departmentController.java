package com.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.department.Department;
import com.hr.service.departmentService;

@RestController
@RequestMapping("/department")
public class departmentController {

	@Autowired
	private departmentService service;

	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping("/")
	public Department insert(@RequestBody Department d) {
		return service.insert(d);
	}

	@PutMapping("/")
	public Department update(@RequestBody Department d) {
		return service.update(d);
	}

}
