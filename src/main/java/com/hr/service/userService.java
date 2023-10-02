package com.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.entity.User;
import com.hr.repository.userRepo;

@Service
public class userService {
	@Autowired
	private userRepo repo;

	public User findById(Long id) {
		return repo.findById(id).orElseThrow();
	}

	public User insert(User e) {
		return repo.save(e);
	}

	public List<User> findAll() {
		return repo.findAll();
	}

	public User update(User e) {
		User current = repo.findById(e.getId()).get();
		current.setName(e.getName());
		current.setPass(e.getPass());
		return repo.save(current);
	}
}
