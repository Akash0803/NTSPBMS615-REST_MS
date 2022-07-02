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
		//Consume Service using xxxforEntity(-) method
		ResponseEntity<String> responce=template.getForEntity(serviceUrl,String.class);
		System.out.println("Responce Body/PayLoad (Output) :: "+responce.getBody());
		System.out.println("Responce Status Code Value :: "+responce.getStatusCodeValue());
		System.out.println("Responce Status Code :: "+responce.getStatusCode());
		System.out.println("Responce Header :: "+responce.getHeaders());
	}

}
