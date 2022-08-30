package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RefreshScope
public class EmployeeOperationController {
	
	@Value("${dbuser}")
	private String dbusername;
	@Value("${dbpwd}")
	private String dbpassword;
	
	public EmployeeOperationController() {
		System.out.println("EmployeeOperationController :: 0 - Param Constructor");
	}	
	@GetMapping("/show")
	public ResponseEntity<String> showDBDetails(){
		return new ResponseEntity<String>("Emp-->DB Details "+dbusername+"----"+dbpassword,HttpStatus.OK);
	}
}
