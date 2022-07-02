package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Student;

@RestController
@RequestMapping("/student/api")
public class StudentOperationController {

	@PostMapping("/register")
	public ResponseEntity<Student> registerStudent(@RequestBody Student  student){
		System.out.println("StudentOperationController.registerStudent()");
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
	}
}
