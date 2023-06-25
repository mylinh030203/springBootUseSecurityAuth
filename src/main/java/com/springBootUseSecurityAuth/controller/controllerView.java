package com.springBootUseSecurityAuth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerView {
	@GetMapping("/login")
	public String Login() {
		return "Login";
	}

}
