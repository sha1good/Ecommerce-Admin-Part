package com.adminportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.domain.ssecurity.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{

	public Role findByName(String name);
}
