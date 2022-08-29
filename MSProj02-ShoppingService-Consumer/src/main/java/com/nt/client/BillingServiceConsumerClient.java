package com.nt.client;



import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceConsumerClient {
	@Autowired
	private DiscoveryClient client;
	
	public String getBillingInfo() {
		//Get Billing-Service Instance from Eureka Server
		List<ServiceInstance> listInstance=client.getInstances("Billing-Service");
		//get Single Instance from list of Instance (no Load Balancing)
		ServiceInstance instance=listInstance.get(0);
		//get Details from Service Instance
		URI uri=instance.getUri();
		//Prepare provider MS related url  to consume  method
		String url=uri.toString()+"/billing/api/info";
		
		//Create RestTemplate class obj to consume provider service
		RestTemplate template=new RestTemplate();
		//Consume Provider Service
		ResponseEntity<String> response=template.getForEntity(url,String.class);
		//get response Content fromResponseEntity obj
		String responseContent=response.getBody();
		
		return responseContent;
	}
}
