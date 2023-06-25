package com.springBootUseSecurityAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootUseSecurityAuth.model.Role;
import com.springBootUseSecurityAuth.repository.RoleRepository;


@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> find(){
		return roleRepository.findAll();
	}
}
