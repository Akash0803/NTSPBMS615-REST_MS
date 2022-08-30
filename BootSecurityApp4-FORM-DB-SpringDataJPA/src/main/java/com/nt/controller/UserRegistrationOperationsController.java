package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.model.UserDetails;
import com.nt.service.IUserRegistrationService;

@Controller
@RequestMapping("/user")

public class UserRegistrationOperationsController {
	@Autowired
	private IUserRegistrationService userService;
	
	@GetMapping("/register") // for form launching
	public String showUserForm(@ModelAttribute("userInfo") UserDetails detais)  {
		return "user_registration";
		
	}
	@PostMapping("/register")
	public String  processRegisterUser(Map<String, Object> map,
														 @ModelAttribute("userInfo") UserDetails details) {
		String msg=userService.registerUser(details);
		map.put("resultMsg", msg);
		return "user_registration_success";
	}
	@GetMapping("/showLogin")
	public String showLoging() {
		//return LVN
		return "custom_login";
	}
}

