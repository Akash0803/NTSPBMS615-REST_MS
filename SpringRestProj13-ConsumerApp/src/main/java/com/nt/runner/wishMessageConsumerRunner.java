package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class wishMessageConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplet class obj
		RestTemplate templet=new RestTemplate();
		//Prepare service URL or base URL + RequstPath
		String serviceurl="http://localhost:2020/SpringRestProj13-ProviderApp/wish/api/message";
					//						http://localhost:2020/SpringRestProj13-ProviderApp/
		//***Consume the Service using xxxForEntity(-) method
		ResponseEntity<String> responce=templet.getForEntity(serviceurl, String.class);
		
		//Process Responce
		System.out.println("Responce Body/PayLoad (Output) :: "+responce.getBody());
		System.out.println("Responce Status Code Value :: "+responce.getStatusCodeValue());
		System.out.println("Responce Status Code :: "+responce.getStatusCode());
		System.out.println("Responce Headers :: "+responce.getHeaders());
		
	}

}
