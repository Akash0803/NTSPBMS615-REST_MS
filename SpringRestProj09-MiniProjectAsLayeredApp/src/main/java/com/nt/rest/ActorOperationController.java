package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.service.IActorMgmtService;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationController {
	@Autowired
	private IActorMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveActor(@RequestBody Actor actor){
		try {
			String msg=service.registorActor(actor);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/report")
	public ResponseEntity<?> fetchAllActors(){
		try {
			Iterable<Actor> list=service.getAllActors();
			return new ResponseEntity<Iterable<Actor>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchActorByID(@PathVariable int id){
		try {
			Actor actor=service.getActorById(id);
			return new ResponseEntity<Actor>(actor,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/actorInfo/{category1}/{category2}")
	public ResponseEntity<?> showActorByCategories(@PathVariable String category1, @PathVariable String category2){
		try {
			List<Actor> list=service.fetchActorByCategory(category1, category2);
			return new ResponseEntity<List<Actor>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/modify")
	public ResponseEntity<?> modifyActor(@RequestBody Actor actor){
		try {
			String msg = service.updateActor(actor);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteActor(@PathVariable("id") int id){
		try {
			String msg=service.deleteActorById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PatchMapping("/updateMobileNo/{id}/{newNo}")
	public ResponseEntity<String> changeActorMobileNo(@PathVariable("id") int id, 
																												@PathVariable("newNo") long newMobile){
		try {
			String msg=service.updateActorMobileNo(id, newMobile);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
