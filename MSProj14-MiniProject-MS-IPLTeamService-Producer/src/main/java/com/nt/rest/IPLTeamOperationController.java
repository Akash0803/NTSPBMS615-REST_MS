package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLTeam;
import com.nt.service.IIPLTeamMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team")
@Slf4j
public class IPLTeamOperationController {
	@Autowired
	private IIPLTeamMgmtService teamService;
	@PostMapping("/save")
	public ResponseEntity<String> registerTeam( @RequestBody IPLTeam team){
		//Use Service
		String msg=teamService.saveTeam(team);
		log.info("IPLTeamOperationController :: Request Came For Team Registration");
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	@GetMapping("/search/{id}")
	public ResponseEntity<IPLTeam> searchIPLTeamById(@PathVariable("id") int id ){
		//use Service
		IPLTeam team=teamService.findTeamById(id);
		log.info("IPLTeamOperationController :: Request Came For Finding Team By ID");
		return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLTeam>> showAllTeam(){
		//use Service
		Iterable<IPLTeam> it=teamService.findAllTeams();
		log.info("IPLTeamOperationController :: Request Came For Showing All Teams");
		return new ResponseEntity<Iterable<IPLTeam>>(it,HttpStatus.OK);
	}

}
