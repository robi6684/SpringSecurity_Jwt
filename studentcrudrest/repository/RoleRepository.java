package com.monocept.studentcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.studentcrudrest.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	Role findByRolename(String rolename);
}
