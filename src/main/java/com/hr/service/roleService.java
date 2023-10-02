package com.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.entity.Role;
import com.hr.repository.roleRepo;

@Service
public class roleService {
	@Autowired
	private roleRepo repo;

	public Role findById(Long id) {
		return repo.findById(id).orElseThrow();
	}

	public Role insert(Role r) {
		return repo.save(r);
	}

	public List<Role> findAll() {
		return repo.findAll();
	}

	public Role update(Role e) {
		Role current = repo.findById(e.getId()).get();
		current.setRoleName(e.getRoleName());
		return repo.save(current);
	}
}
