package com.nt.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerAPIDocConfig {
	@Bean
	public Docket  cerateDocket() {
		return new Docket(DocumentationType.SWAGGER_2)   //to Swagger UI type
												.select()
												.apis(RequestHandlerSelectors.basePackage("com.nt.rest"))  //to specify base pkg of @RestController classes
												.paths(PathSelectors.regex("/actor.*"))  //global path
												.build() //Builds the Docket obj
												.useDefaultResponseMessages(true)
												.apiInfo(createAPIInfo());
	}
	
	
	//Helper method
	private ApiInfo createAPIInfo() {
		Contact contact=new Contact("Raja", "http://www.HCL.com/tourist", "Akash@gmail.com");
		return new ApiInfo( "Actor-API Doc1",
												"API Info Actor API",
												"5.7.RELEASE",
												"http://HCL.com/license",
												contact,
												"GNU Public",
												"http://www.gnu.license.com",
												Collections.emptyList());
	}
}
