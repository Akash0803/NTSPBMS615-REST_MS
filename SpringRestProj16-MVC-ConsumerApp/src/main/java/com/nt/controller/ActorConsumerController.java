package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
public class ActorConsumerController {
	@Autowired
	private RestTemplate template;
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "home";
	}
	
	@GetMapping("/actor_report")
	public String fetchAllActor(Map<String, Object> map) throws Exception{
		/*
		 * provider Url :: http://localhost:2020/SpringRestProj16-ProviderApp-Actor/actor/api/report
		 * request method/mode :: GET
		 * path variable :: NO
		 * response Content :: application/json (default)
		 * request headers :: NO
		 * request Body type :: NO
		 */
		String serviceurl=env.getProperty("fetchAllActors.serviceurl");
		//invoke Provider -RestController operation/method using exchange(...) of RestTempalte 
		ResponseEntity<String> response=template.exchange(serviceurl,HttpMethod.GET,null,String.class);
		//get JSON response from response Obj
		String jsonBody=response.getBody();
		System.out.println("JSON Body :: "+jsonBody);
		//convert JSON body into List<Actor> object
		ObjectMapper mapper = new ObjectMapper();
		List<Actor> list=mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {});
		System.out.println("Jaava Response :: "+list);
		map.put("actorsInfo", list);
		System.out.println("Map :: "+map);
		return "show_report";
	}
	@GetMapping("/actor_add")
	public String showRegisterActorFormPage(@ModelAttribute("performer") Actor actor) {
		//return LVN
		return "register_actor";
	}
//	@PostMapping("/actor_add")
//	public String registerActor(@ModelAttribute("actor") Actor actor,
//															Map<String , Object> map)throws Exception {
//		//convert model Class obj data to JSON content using ObjectMapper
//		ObjectMapper mapper=new ObjectMapper();
//		String jsonContent=mapper.writeValueAsString(actor);
//		System.out.println("JsonContent :: "+jsonContent);
//		//invoke provider Applications operation to save actor object
//		/*
//		 * provider Url :: http://localhost:2020/SpringRestProj16-ProviderApp-Actor/actor/api/save
//		 * request method/mode :: POST
//		 * path variable :: NO
//		 * response Content :: text/plain
//		 * request headers :: application/json (default)
//		 * request Body type :: Json Content
//		 */
//		String serviceurl=env.getProperty("registerActor.serviceurl");
//		//prepare http Headers
//		HttpHeaders headers=new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		//prepare HttpEntity object having headers + body
//		HttpEntity<String> entity=new HttpEntity<String>(jsonContent,headers);
//		ResponseEntity<String> response=template.exchange(serviceurl, 
//																													HttpMethod.POST,
//																													entity,
//																													String.class);
//		//get provider operation result
//		String msg=response.getBody();
//		//keep result in model attribute(shared memory)
//		map.put("resultMsg", msg);
//		//return "forward:actor_report"; //POST mode requst can not be forwarded to GRT mode request (gives error)
//		return "redirect:actor_report"; //we can not use model attributes in this method in redirected request releted methods/pages
//	}
	
	
	@PostMapping("/actor_add")
	public String registerActor(@ModelAttribute("actor") Actor actor,
															RedirectAttributes attrs)throws Exception {
		//convert model Class obj data to JSON content using ObjectMapper
		ObjectMapper mapper=new ObjectMapper();
		String jsonContent=mapper.writeValueAsString(actor);
		System.out.println("JsonContent :: "+jsonContent);
		//invoke provider Applications operation to save actor object
		/*
		 * provider Url :: http://localhost:2020/SpringRestProj16-ProviderApp-Actor/actor/api/save
		 * request method/mode :: POST
		 * path variable :: NO
		 * response Content :: text/plain
		 * request headers :: application/json (default)
		 * request Body type :: Json Content
		 */
		String serviceurl=env.getProperty("registerActor.serviceurl");
		//prepare http Headers
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare HttpEntity object having headers + body
		HttpEntity<String> entity=new HttpEntity<String>(jsonContent,headers);
		ResponseEntity<String> response=template.exchange(serviceurl, 
																													HttpMethod.POST,
																													entity,
																													String.class);
		//get provider operation result
		String msg=response.getBody();
		//keep result in model attribute(shared memory)
		attrs.addFlashAttribute("resultMsg", msg);
		//return "forward:actor_report"; //POST mode requst can not be forwarded to GRT mode request (gives error)
		return "redirect:actor_report"; //we can use flash attributes in this method and also in redirected request releted methods/pages
	}
	@GetMapping("/actor_edit")
	public String showUpdateFormPage(@RequestParam("aid") int id,
																			@ModelAttribute("artist") Actor actor)throws Exception{
		//invoke provider App () operation that gives actor info based on actor id
		/*
		 * provider Url :: http://localhost:2020/SpringRestProj16-ProviderApp-Actor/actor/api/getactor/{id}
		 * request method/mode :: Get
		 * path variable :: {id}
		 * response Content  Type:: application/json
		 * request headers :: no
		 * request Body type :: default
		 */
		String  serviceUrl=env.getProperty("updateActor.serviceurl1");
		ResponseEntity<String > response=template.exchange(serviceUrl, 
																													HttpMethod.GET,
																													null,
																													String.class,
																													Map.of("id", id));
		//Convert Json response Body to Model class obj
		ObjectMapper mapper=new ObjectMapper();
		Actor actor1=mapper.readValue(response.getBody(), Actor.class);
		//copy actor1 oject data to ModelAtrtribute Actor Obj
		BeanUtils.copyProperties(actor1, actor);
		//return LVN
		return  "update_actor";
	}
	
	@PostMapping("/actor_edit")
	public String updateActor(@ModelAttribute("actor") Actor actor,
															RedirectAttributes attrs)throws Exception {
		//convert model Class obj data to JSON content using ObjectMapper
		ObjectMapper mapper=new ObjectMapper();
		String jsonContent=mapper.writeValueAsString(actor); //Serialization
		System.out.println("JsonContent :: "+jsonContent);
		//invoke provider Applications operation to update actor object
		/*
		 * provider Url :: http://localhost:2020/SpringRestProj16-ProviderApp-Actor/actor/api/modify
		 * request method/mode :: PUT
		 * path variable :: NO
		 * request headers :: application/json (default)
		 * request Body type :: Json Content
		 * response Content :: text/plain
  		 */
		String serviceurl=env.getProperty("updateActor.serviceurl2");
		//prepare http Headers
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare HttpEntity object having headers + body
		HttpEntity<String> entity=new HttpEntity<String>(jsonContent,headers);
		ResponseEntity<String> response=template.exchange(serviceurl, 
																													HttpMethod.PUT,
																													entity,
																													String.class);
		//get provider operation result
		String msg=response.getBody();
		//keep result in model attribute(shared memory)
		attrs.addFlashAttribute("resultMsg", msg);
		//return "forward:actor_report"; //POST mode requst can not be forwarded to GRT mode request (gives error)
		return "redirect:actor_report"; //we can use flash attributes in this method and also in redirected request releted methods/pages
	}
	@GetMapping("/actor_delete")
	public String deleteActor(@RequestParam("aid") int id,
														RedirectAttributes attrs) {
		//invoke provider RestAPI comp operation
		/*
		 * provider Url :: http://localhost:2020/SpringRestProj16-ProviderApp-Actor/actor/api/delete/{id}
		 * request method/mode :: DELETE
		 * path variable :: {id}
		 * request headers :: no
		 * request Body type :: no
		 * response Content :: text/plain
  		 */
		String serviceurl=env.getProperty("deleteActor.serviceurl");
		ResponseEntity<String> responce=template.exchange(serviceurl,
																													HttpMethod.DELETE, 
																													null,
																													String.class,
																													Map.of("id",id));

		//keep the response body (plan text) in flash Attribute
		String msg=responce.getBody();
		//add result as flash attribute
		attrs.addFlashAttribute("resultMsg",msg);
		//redirect the request
		return "redirect:actor_report";
	}
}
