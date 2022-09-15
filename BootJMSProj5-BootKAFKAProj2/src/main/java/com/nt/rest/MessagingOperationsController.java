package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.consumer.MessageStore;
import com.nt.producer.MessageProducer;

@RestController
public class MessagingOperationsController {
	@Autowired
	private MessageProducer producer;
	@Autowired
	private MessageStore store;
	@GetMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String msg ){
		//use producer
		String msgStatus=producer.sendMessage(msg);
		//return ResponseEntity<String> Obj
		return new ResponseEntity<String>(msgStatus,HttpStatus.OK);
		
	}
	
//	@GetMapping("/readAll")
//	public ResponseEntity<List<String>> showAllMessage(){
//		//Get All Msg
//		List<String> list=store.getAllMessage();
//		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
//		
//	}
	
	@GetMapping("/readAll")
	public ResponseEntity<String> showAllMessage(){
		//Get All Msg
		List<String> list=store.getAllMessage();
		return new ResponseEntity<String>("<h1>"+list+"</h1>",HttpStatus.OK);
		
	}
}
