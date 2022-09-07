package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationsController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	/*@GetMapping("/balance")
	public String showBalance(Map<String, Object> map) {
		map.put("balance",new Random().nextInt(10000));
		return "show_balance";
	}
	*/
	//For Checking CSRFTest App bcoz it works only in Post Mode Request
	@PostMapping("/balance")
	public String showBalance(Map<String, Object> map) {
		map.put("balance",new Random().nextInt(10000));
		return "show_balance";
	}
	@GetMapping("/approveLoan")
	public String loans(Map<String, Object> map) {
		map.put("loanAmt",new Random().nextInt(1000000));
		return "loan";
	}
	//for Authorization failure
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}
}
