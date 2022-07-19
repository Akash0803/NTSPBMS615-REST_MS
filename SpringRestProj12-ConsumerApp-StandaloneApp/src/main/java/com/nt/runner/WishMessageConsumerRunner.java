package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class WishMessageConsumerRunner implements CommandLineRunner {
	@Autowired
	private RestTemplate template;
	@Value("${service.url}")
	private String serviceUrl;
	@Override
	public void run(String... args) throws Exception {
		ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class);
		System.out.println("Response Body :: "+response.getBody());
		System.out.println("Response Status Code Value :: "+response.getStatusCodeValue());
		System.out.println("Response Status Code :: "+response.getStatusCode());
		System.out.println("Response Headers :: "+response.getHeaders());
		
	}

}
