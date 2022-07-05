package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class GetModeConsumerRunner1 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate class Obj
		RestTemplate template=new RestTemplate();
		//Prepare serviceUrl
		String serviceUrl="http://localhost:2020/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/report";
		//invoke exchange(...) Method
		ResponseEntity<String> response=template.exchange(serviceUrl, 
																													HttpMethod.GET,
																													null, // No Body No Header
																													String.class);
		System.out.println("GET Mode Request");
		System.out.println("Responce Body :: "+response.getBody());
		System.out.println("Responce Status Code Value :: "+response.getStatusCodeValue());
		System.out.println("Responce Status Code :: "+response.getStatusCode());
		System.out.println("Responce Headers :: "+response.getHeaders());
		System.out.println("-------------------------------------------------------------------------------");
		
		String serviceUrl2="http://localhost:2020/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/message/{id}/{name}";
		// Inovoke exchange(---) Method
		ResponseEntity<String> response2=template.exchange(serviceUrl, 
																														HttpMethod.GET,
																														null,
																														String.class,
																														Map.of("id",1001,"name","Rajesh"));
		System.out.println("GET Mode Request Using Map");
		System.out.println("Responce Body :: "+response.getBody());
		System.out.println("Responce Status Code Value :: "+response.getStatusCodeValue());
		System.out.println("Responce Status Code :: "+response.getStatusCode());
		System.out.println("Responce Headers :: "+response.getHeaders());
		System.out.println("-------------------------------------------------------------------------------");
		
	}

}
