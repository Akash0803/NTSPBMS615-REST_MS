package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class TouristInfoConsumer_Posting_JSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Creating RestTemplate Class Obj
		RestTemplate template=new RestTemplate();
		//Prepare serviceUrl
		String serviceUrl=	"http://localhost:2020/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/register";
		//prepare Header
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); //Optional while Sending JSON data
		//Prepare HttpRequest as HttpEntity having Headers and Body
		String json_data="{\"tid\":101,\"tname\":\"Rahul\",\"startPlace\":\"hyd\",\"destPlace\":\"Goa\"}";
		HttpEntity<String> requst=new HttpEntity<String>(json_data,headers);
		//Send POST Mode Request Using exchange(...) Method
		ResponseEntity<String> response=template.exchange(serviceUrl, 	
																													HttpMethod.POST, 
																													requst,
																													String.class);
		System.out.println("POST Mode Request");
		System.out.println("Responce Body :: "+response.getBody());
		System.out.println("Responce Status Code Value :: "+response.getStatusCodeValue());
		System.out.println("Responce Status Code :: "+response.getStatusCode());
		System.out.println("Responce Headers :: "+response.getHeaders());
		System.out.println("-------------------------------------------------------------------------------");
		

	}

}
