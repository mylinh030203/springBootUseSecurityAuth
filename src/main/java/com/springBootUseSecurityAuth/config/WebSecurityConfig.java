package com.springBootUseSecurityAuth.config;

import javax.sql.DataSource;

import org.apache.catalina.User;
import org.apache.el.parser.AstTrue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true )123
public class WebSecurityConfig{
	@Bean
	 public UserDetailsService userDetailsService() {
//		 UserDetails admin = org.springframework.security.core.userdetails.User.withUsername("linh123")
//				 .password(encoder.encode("123")).roles("admin").build();
//		 UserDetails user = org.springframework.security.core.userdetails.User.withUsername("linptm")
//				 .password(encoder.encode("123")).roles("user").build();
//		return new InMemoryUserDetailsManager(admin,user);
		
		return new UserDetailService();
		 
	 }
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		 return http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/role").permitAll()
		.and()
		.authorizeHttpRequests()
//		.requestMatchers("/admin","/user","/user/ListUser ").authenticated()
		.requestMatchers(new AntPathRequestMatcher("/user/**"),new AntPathRequestMatcher("/admin/**"))
		.authenticated()
//		.requestMatchers(new AntPathRequestMatcher("/user/**")).hasRole("USER")
		.and().formLogin()
		.loginProcessingUrl("/authenticate").loginPage("/login").permitAll().defaultSuccessUrl("/login?success = true")
		.failureUrl("/login?success = false")
		.and().build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

}
