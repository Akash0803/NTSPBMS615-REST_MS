package com.nt.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingRestController {
	int count=0;
	@GetMapping("/book")
//	@HystrixCommand(fallbackMethod = "dummyBookTicket",
//										    commandProperties = {
//										    		@HystrixProperty(name = "circuitBreaker.enabled", value = "true")
//										    })
	
	
	@HystrixCommand(fallbackMethod = "dummyBookTicket",
															commandProperties = {
																						@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
																						@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
																						@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5")
    																					}
											)

	public String bookTicket() {
		System.out.println("TicketBookingRestController.bookTicket()");
		if(new Random().nextInt(10)<10)
			throw new RuntimeException("Problem in B.logic.....?");
		return "Output From B.logic";
	}
	public String dummyBookTicket() {
		count++;
		System.out.println("TicketBookingRestController.dummyBookTicket() :: "+count);
		return "Plese try later = Inconvience is regratted"; 
		
	}
}
