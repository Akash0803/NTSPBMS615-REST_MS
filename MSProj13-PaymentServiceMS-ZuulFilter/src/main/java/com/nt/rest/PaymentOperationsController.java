package com.nt.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/PaymentMS")
public class PaymentOperationsController {
	

	@GetMapping("/payment")
	public String doPayment() {
		return " Payment has done by PhonePay UPI";
	}
}
