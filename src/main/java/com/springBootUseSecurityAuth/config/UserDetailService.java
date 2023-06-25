package com.springBootUseSecurityAuth.config;

import java.util.Optional;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springBootUseSecurityAuth.model.User;
import com.springBootUseSecurityAuth.repository.UserRepository;
@Component
public class UserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional <User> user = repository.findByUserName(username);
		return user.map(UserDetail::new)
		.orElseThrow(()->new UsernameNotFoundException("user not found"+username));
		
	}

}
