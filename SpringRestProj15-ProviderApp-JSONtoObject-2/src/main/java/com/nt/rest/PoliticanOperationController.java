package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Address;
import com.nt.model.Politician;

@RestController
@RequestMapping("/politican/api")
public class PoliticanOperationController {
	@GetMapping("/find/{id}")
	public ResponseEntity<Politician> findPoliticanById(@PathVariable("id") int id ) {
		return new ResponseEntity<Politician>(new Politician(id, "Modi", "BJP", "PM", 60.0f,
																					  new Address("1-23","RK Street",0022L)),
																					  HttpStatus.OK);
	}
//	@GetMapping("/report")
//	public ResponseEntity<List<Politician>> showAllPoliticans() {
//		List<Politician> list=List.of(new Politician(101,"Modi","BJP","PM",60.0f),
//															 new Politician(102,"Amit Shaha","BJP","Hm",65.0f),
//															 new Politician(102,"Yogi","BJP","CM",40.0f));
//		return new ResponseEntity<List<Politician>>(list,HttpStatus.OK);
//	}
//	@GetMapping("/report1")
//	public ResponseEntity<Map<String,Object>> showCards() {
//		Map<String,Object>map=Map.of("adhar",101010,"voterId",202020,"passport",303030);
//		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
//	}
//	
}
