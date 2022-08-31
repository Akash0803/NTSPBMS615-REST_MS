package com.nt.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingRestController {

	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyBookTicket")
	public String bookTicket() {
		System.out.println("TicketBookingRestController.bookTicket()");
		if(new Random().nextInt(10)<10)
			throw new RuntimeException("Problem in B.logic.....?");
		return "Output From B.logic";
	}
	public String dummyBookTicket() {
		System.out.println("TicketBookingRestController.dummyBookTicket()");
		return "Plese try later = Inconvience is regratted"; 
		
	}
}
