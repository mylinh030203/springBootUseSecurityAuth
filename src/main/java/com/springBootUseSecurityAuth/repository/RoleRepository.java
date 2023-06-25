package com.springBootUseSecurityAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springBootUseSecurityAuth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>,JpaSpecificationExecutor<Role>{

}
