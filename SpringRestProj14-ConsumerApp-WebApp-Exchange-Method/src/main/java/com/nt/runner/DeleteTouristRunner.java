package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class DeleteTouristRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate Clast Obj
		RestTemplate template=new RestTemplate();
		//Prepare serviceUrl
		String serviceUrl="http://localhost:2020/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/delete/{id}";
		//Send Delete Mode Request using exchange(---) method
		ResponseEntity<String> response=template.exchange(serviceUrl,
																													HttpMethod.DELETE,
																													null,
																													String.class,
																													101);
		System.out.println("Delete Mode Request");
		System.out.println("Responce Body :: "+response.getBody());
		System.out.println("Responce Status Code Value :: "+response.getStatusCodeValue());
		System.out.println("Responce Status Code :: "+response.getStatusCode());
		System.out.println("Responce Headers :: "+response.getHeaders());
		System.out.println("-------------------------------------------------------------------------------");
		

	}

}
