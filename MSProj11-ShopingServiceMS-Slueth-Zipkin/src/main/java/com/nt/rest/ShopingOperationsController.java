package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ShoppingMS")
public class ShopingOperationsController {
	@Autowired
	private RestTemplate template;
	
	
	private Logger logger = LoggerFactory.getLogger(ShopingOperationsController.class);
	@GetMapping("/shopping")
	public String doShopping() {
		logger.info("ShopingOperationsController :: Shopping Operation just Started");
		//invoke the method of another Micro Service (BillingOperationsController - MS) 
		String msg=template.getForObject("http://localhost:9092/BillingMS/billing", String.class); //IntraCommunication MS
		logger.info("Billing Service is Invoked");
		logger.info("Back to Shopping Service");
		return "Shoping Operation "+msg;
	}
}
