package com.springBootUseSecurityAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springBootUseSecurityAuth.model.User;
import com.springBootUseSecurityAuth.vo.UserVO;

public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>{

	Optional<User> findByUserName(String username);

}
