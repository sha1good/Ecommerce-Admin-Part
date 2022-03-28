 package com.adminportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adminportal.Utility.SecrityUtility;
import com.adminportal.domain.User;
import com.adminportal.domain.ssecurity.Role;
import com.adminportal.domain.ssecurity.UserRole;
import com.adminportal.service.UserService;


@SpringBootApplication
public class AdminportalApplication implements CommandLineRunner {


	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(AdminportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setUsername("admin1");
		user1.setEmail("admin@yahoo.com");
		user1.setPassword(SecrityUtility.passwordEncoder().encode("admin1"));

		Set<UserRole> userRoles= new HashSet<>();

		Role role1= new Role();
		role1.setRoleId(2);
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1,role1));

		userService.createUser(user1,userRoles);

	}

}
