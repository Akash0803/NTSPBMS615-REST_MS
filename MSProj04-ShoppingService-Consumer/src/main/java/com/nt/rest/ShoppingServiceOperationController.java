package com.nt.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceOperationController {
	@Autowired
	private IBillingServiceConsumerClient client; 
	@GetMapping("/cart")
	public ResponseEntity<String> doShopping() {
		//Use Client Component
		String resultMsg=client.fetchBillingInfo().getBody();
		
		System.out.println("Proxy Class Name :: "+client.getClass()+" ------"+Arrays.toString(client.getClass().getInterfaces()));
		try {
			Thread.sleep(20000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Shopping the Items(Shirt,trouser) :: "+resultMsg,HttpStatus.OK);
	}
}
