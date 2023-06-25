package com.springBootUseSecurityAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBootUseSecurityAuth.service.RoleService;
import com.springBootUseSecurityAuth.service.UserService;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class controller {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@PreAuthorize("hasAuthority('ctsv')")	
	@GetMapping("/user")
	public String hello(@RequestParam(value = "Linh", defaultValue = "World")String name) {
		return String.format("Hello %s !", name);
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin")
	public String helloAmin(@RequestParam(value = "Linh", defaultValue = "Linh")String name) {
		return String.format("Hello %s !", name);
	}
	@GetMapping("/role")
	public String listRole() {		
		return roleService.find().toString();
	}
	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('USER')")
	@GetMapping("/user/ListUser")
	public String ListUser() {
		return userService.findAll().toString();
	}

}
