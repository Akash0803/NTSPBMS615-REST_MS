package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfigAdapter extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//InMemory DB
//		auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
//		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}hyd").roles("MANAGER");
//		auth.inMemoryAuthentication().withUser("jani").password("{noop}begum").roles("MANAGER","CLERK");
//		auth.inMemoryAuthentication().withUser("suresh").password("{noop}delhi").roles("VISITOR");
		
		
		//InMemory DB with Encoded password
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$s4zSONrFGQPCbbgN1bomFeybM4vahrhKjuc0dRrbDVA5DwXNsexWu").roles("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("rajesh").password("$2a$10$ACeIbSAQQWWpJfHVzOKrR.ckl3/tHm0o/bSCcmm11EVSQ4HG6SDX.").roles("MANAGER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("jani").password("$2a$10$34b8fU17xqgPQl43v/EdQ.oqYr1m./J7xWlnZANtyCsLfwyRhNAge").roles("MANAGER","CLERK");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("suresh").password("$2a$10$ncJ85DgUZS3b0SgHCfZhjOhtiPmERUG5faPSBom5EAvZeUAQMaoSC").roles("CUSTOMER");
	
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//Authenticate and Authorize URLs
		http.authorizeRequests().antMatchers("/").permitAll()
		                                                  .antMatchers("/offers").authenticated()
		                                                  .antMatchers("/balance").hasAnyRole("MANAGER","CUSTOMER")
		                                                  .antMatchers("/approveLoan").hasRole("MANAGER")
		                                                  .anyRequest().authenticated()
		                                                  
		 //to enable BASIC Authentication(uses there browser supplied dialog box)
		 // .and().httpBasic()
		  
		 //To enable form based Authentication
		 .and().formLogin()                  
		 
		 //enables remember Me authentication option in form based Authentication
		 .and().rememberMe()
		 
		 //enable logout
		 //.and().logout()
		 //enable logout with custom url
		 .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		 
		  //configure custom error page for 304 error page
		  .and().exceptionHandling().accessDeniedPage("/denied")
		
		//Session max Concurrency control
		 .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		 
	}
}
