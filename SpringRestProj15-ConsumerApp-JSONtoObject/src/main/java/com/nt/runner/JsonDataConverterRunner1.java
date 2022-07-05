package com.nt.runner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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
public class JsonDataConverterRunner1 implements CommandLineRunner {
	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		//Prepare ServiceUrl
		String serviceUrl="http://localhost:2020/SpringRestProj15-ProviderApp-JSONtoObject/politican/api/report";
		//Invoke the Rest Api
		ResponseEntity<String> response=template.exchange(serviceUrl,
																													HttpMethod.GET,
																													null,
																													String.class);
		System.out.println("JsonDataConverterRunner1.run()");
		System.out.println("---------------------------------List<T>----------------------------");
		System.out.println("Responce Body :: "+response.getBody() );
		System.out.println("Responce Status Code :: "+response.getStatusCode()+" Status Code Value :: "+response.getStatusCodeValue() );
		System.out.println("Responce Headers :: "+response.getHeaders() );
		System.out.println("-----------------------------------JSON Object Convertion List<T>-------------------------------------");
		//Convert recived JSON Data into Java Class Object using Jackson api (DeSerialization)
		ObjectMapper mapper=new ObjectMapper();
		Politician politicians[]=mapper.readValue(response.getBody(),Politician[].class);
		List<Politician> list=Arrays.asList(politicians);
		list.forEach(System.out::println);
		System.out.println("-------------------------------------");
		List<Politician> list1=mapper.readValue(response.getBody(), new TypeReference<List<Politician>>() {});
		list1.forEach(System.out::println);
	}

}
