package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class WishMessageConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate template=new RestTemplate();
		String serviceURL="http://localhost:2020/SpringRestProj12-ProviderApp/wish/api/message";
		ResponseEntity<String> response=template.getForEntity(serviceURL, String.class);
		System.out.println("Response Body :: "+response.getBody());
		System.out.println("Response Status Code Value :: "+response.getStatusCodeValue());
		System.out.println("Response Status Code :: "+response.getStatusCode());
		System.out.println("Response Headers :: "+response.getHeaders());
		
	}

}
