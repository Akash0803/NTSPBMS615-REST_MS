package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class WishMessageConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate class Obj
		RestTemplate template=new RestTemplate();
		//Prepare serviceUrl or BaseUrl + RequestPath
		String serviceUrl="http://localhost:2020/SpringRestProj13-ProviderApp-PathVariable-JSONData/wish/api/message/{id}/{name}";
										// http://localhost:2020/SpringRestProj13-ProviderApp-PathVariable-JSONData/wish/api/message/{id}/{name}
		
		//Consume Service using xxxForEntity(-) method
		ResponseEntity<String> response=template.getForEntity(serviceUrl,String.class,
																														  Map.of("name","Raja","id",101));
																														  //Map Obj to pass PathVariable Values
																														 //Here we need not follow the order
		System.out.println("Response Body/Payload (Output) ::  "+response.getBody());
		System.out.println("Response Ststus Code Value ::  "+response.getStatusCodeValue());
		System.out.println("Response Status Code ::  "+response.getStatusCode());
		System.out.println("Response Headers ::  "+response.getHeaders());
		System.out.println("===============================================================");
		String response1=template.getForObject(serviceUrl, String.class,102,"Rajesh");
																																		//var args to pass PathVariable values
																																		//here we need to follow the order
		
		System.out.println("Response Content is :: "+response1);//Gives only response body
	}

}
