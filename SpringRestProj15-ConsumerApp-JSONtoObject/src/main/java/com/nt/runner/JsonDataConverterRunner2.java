package com.nt.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Politician;
@Component
public class JsonDataConverterRunner2 implements CommandLineRunner {
	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		//Prepare ServiceUrl
		String serviceUrl="http://localhost:2020/SpringRestProj15-ProviderApp-JSONtoObject/politican/api/report1";
		//Invoke the Rest Api
		ResponseEntity<String> response=template.exchange(serviceUrl,
																													HttpMethod.GET,
																													null,
																													String.class);
		System.out.println("JsonDataConverterRunner2.run()");
		
		System.out.println("---------------------------------Map<K,V>----------------------------");
		System.out.println("Responce Body :: "+response.getBody() );
		System.out.println("Responce Status Code :: "+response.getStatusCode()+" Status Code Value :: "+response.getStatusCodeValue() );
		System.out.println("Responce Headers :: "+response.getHeaders() );
		System.out.println("-----------------------------------JSON Object Convertion Map<K,V>-------------------------------------");
		//Convert recived JSON Data into Java Class Object using Jackson api (DeSerialization)
		ObjectMapper mapper=new ObjectMapper();
		Map<String, Object> map=mapper.readValue(response.getBody(),new TypeReference<Map<String, Object>>() {});
		System.out.println("ID Detais Map :: "+map);
	

	}

}
