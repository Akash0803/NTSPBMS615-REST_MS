package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/BillingMS")
public class BillingOperationsController {
	@Autowired
	private RestTemplate template;
	
	
	private Logger logger = LoggerFactory.getLogger(BillingOperationsController.class);
	@GetMapping("/billing")
	public String doBilling() {
		logger.info("BillingOperationsController :: Billing Operation just Started");
		//invoke the method of another Micro Service (PaymentOperationsController - MS) 
		String msg=template.getForObject("http://localhost:9093/PaymentMS/payment", String.class); //IntraCommunication MS
		logger.info("Payment Service is Invoked");
		logger.info("Back to Billing Service");
		return " Bill Amt :: 90000 "+msg;
	}
}
