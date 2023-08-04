package com.monocept.studentcrudrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.studentcrudrest.entities.Role;
import com.monocept.studentcrudrest.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
		System.out.println("Role saved successfully");
		
	}
	
}
