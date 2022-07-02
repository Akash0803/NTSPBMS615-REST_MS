package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentOperationsController {
//	@GetMapping("/report/{sno}/{sname}")
//	private ResponseEntity<String> showReport(@PathVariable("sno") int no,
//																				 @PathVariable String sname) {
//		
//		return new ResponseEntity<String>(no+"  "+sname,HttpStatus.OK);
//	}
	@GetMapping("/report/{sno}/{sname}")
	private ResponseEntity<String> showReport1(@PathVariable(name= "sno", required = false)  int no,
																				 @PathVariable(required=false) String sname) {
		System.out.println("StudentOperationsController.showReport1()");
		return new ResponseEntity<String>(no+"  "+sname,HttpStatus.OK);
	}
	@GetMapping("/report/sno/{sname}")
	private ResponseEntity<String> showReport2(@PathVariable(name= "sno", required = false)  Integer no,
																					@PathVariable(required=false) String sname) {
		System.out.println("StudentOperationsController.showReport2()");
        return new ResponseEntity<String>(no+"  "+sname,HttpStatus.OK);
	}
	
	@GetMapping("/report/{sno}/sname")
	private ResponseEntity<String> showReport3(@PathVariable(name= "sno", required = false)  Integer no,
																					@PathVariable(required=false) String sname) {
		System.out.println("StudentOperationsController.showReport2()");
        return new ResponseEntity<String>(no+"  "+sname,HttpStatus.OK);
	}
	@GetMapping("/report/sno/sname")
	private ResponseEntity<String> showReport4(@PathVariable(name= "sno", required = false)  Integer no,
																					@PathVariable(required=false) String sname) {
		System.out.println("StudentOperationsController.showReport2()");
        return new ResponseEntity<String>(no+"  "+sname,HttpStatus.OK);
	}
}
