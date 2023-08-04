package com.monocept.studentcrudrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.studentcrudrest.entities.Role;
import com.monocept.studentcrudrest.service.RoleService;

@RestController
@RequestMapping("/roleapp")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/saveRole")
	public void saveRole(@RequestBody Role role) {
		roleService.saveRole(role);
	}
}
