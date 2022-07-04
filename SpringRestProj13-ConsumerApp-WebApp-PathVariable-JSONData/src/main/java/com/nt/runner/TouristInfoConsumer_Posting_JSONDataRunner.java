package com.nt.runner;



import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class TouristInfoConsumer_Posting_JSONDataRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate Object
		RestTemplate template=new RestTemplate();
		//Create serviceUrl
		//Create serviceUrl or Base Url + requestPath
		String serviceUrl="http://localhost:2020/SpringRestProj13-ProviderApp-PathVariable-JSONData/wish/api/register";
		//Prepare HttpHeaders
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); //Optional while sending JSON data
		//Prepare HttpRequest as HttpEntity having Headers body
		String json_body="{\"tid\":101,\"tname\":\"Rahul\",\"startPlace\":\"hyd\",\"destPlace\":\"Goa\"}";
		//prepare Request
		HttpEntity<String> request=new HttpEntity<String>(json_body,headers);
		//Send POST mode request to consume rest api service
		ResponseEntity<String> response=template.postForEntity(serviceUrl, request, String.class);
		System.out.println("Post Mode Request::");
		System.out.println("Responce Body :: "+response.getBody());
		System.out.println("Responce Ststus Code Value :: "+response.getStatusCodeValue());
		System.out.println("Responce Status Code :: "+response.getStatusCode());
		System.out.println("Responce Headers :: "+response.getHeaders());
		//Send POST mode request to consume rest api service via xxxForObject()
		String responce2=template.postForObject(serviceUrl, request, String.class);
		System.out.println("Post Respone from postForObject() :: ");
		System.out.println("Responce Body :: "+responce2);
	}

}
