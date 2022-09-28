package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLPlayer;
import com.nt.service.IIPLPlayerMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player")
@Slf4j
public class IPLPlayerOperationController {
	@Autowired
	private IIPLPlayerMgmtService playerService;
	@PostMapping("/save")
	public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		//Use Service
		String msg=playerService.registerPlayer(player);
		log.info("RestController :: Request Came For Player Saveing");
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLPlayer>> showAllPlayers() {
		//use Service
		Iterable<IPLPlayer> it=playerService.showAllPlayer();
		log.info("RestController :: Request Came For Showing All Players");
		return new ResponseEntity<Iterable<IPLPlayer>>(it, HttpStatus.OK);
	}
}
