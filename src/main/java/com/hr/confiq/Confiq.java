package com.hr.confiq;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hr.entity.Role;
import com.hr.entity.User;
import com.hr.service.roleService;
import com.hr.service.userService;

@Component
public class Confiq implements CommandLineRunner {

	@Autowired
	private userService userS;
	@Autowired
	private roleService roleS;

	@Override
	public void run(String... args) throws Exception {
		if (userS.findAll().isEmpty()) {

			// create roles and save
			Role role1 = new Role();
			role1.setRoleName("admin");

			Role role2 = new Role();
			role2.setRoleName("guest");

			Role role3 = new Role();
			role3.setRoleName("user");

			roleS.insert(role1);
			roleS.insert(role2);
			roleS.insert(role3);

			// create users and save
			Set<Role> adminRole = new HashSet<>();
			adminRole.add(role1);
			adminRole.add(role2);
			adminRole.add(role3);

			Set<Role> guestRole = new HashSet<>();
			guestRole.add(role2);

			Set<Role> userRole = new HashSet<>();
			userRole.add(role3);
			userRole.add(role2);

			User user1 = new User();
			user1.setName("admin");
			user1.setPass("12345");
			user1.setRoles(adminRole);

			User user2 = new User();
			user2.setName("guest");
			user2.setPass("12345");
			user2.setRoles(guestRole);

			User user3 = new User();
			user3.setName("user");
			user3.setPass("12345");
			user3.setRoles(userRole);

			userS.insert(user1);
			userS.insert(user2);
			userS.insert(user3);
		}
	}
}
