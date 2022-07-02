package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/api")
public class CustomerOperationController {
	@GetMapping("/report")
	private ResponseEntity<String> showReport(@RequestParam("cno") int no,
																				 @RequestParam String cname) {
		
		return new ResponseEntity<String>(no+"  "+cname,HttpStatus.OK);
	}
}
