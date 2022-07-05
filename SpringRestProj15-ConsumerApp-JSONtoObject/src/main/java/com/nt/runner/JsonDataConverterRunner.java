package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Politician;
@Component
public class JsonDataConverterRunner implements CommandLineRunner {
	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		//Prepare ServiceUrl
		String serviceUrl="http://localhost:2020/SpringRestProj15-ProviderApp-JSONtoObject/politican/api/find/{id}";
		//Invoke resr api
		ResponseEntity<String> response=template.exchange(serviceUrl, 
																													HttpMethod.GET,
																													null,
																													String.class,
																													101);
		System.out.println("JsonDataConverterRunner.run()");
		System.out.println("Responce Body :: "+response.getBody() );
		System.out.println("Responce Status Code :: "+response.getStatusCode()+" Status Code Value :: "+response.getStatusCodeValue() );
		System.out.println("Responce Headers :: "+response.getHeaders() );
		System.out.println("------------------------------------------------------------------------");
		//Convert recived JSON Data into Java Class Object using Jackson api (DeSerialization)
		ObjectMapper mapper=new ObjectMapper();
		Politician politician=mapper.readValue(response.getBody(),Politician.class);
		System.out.println("Json Object Converted Data in Java Obj  :: "+politician );
	}

}
