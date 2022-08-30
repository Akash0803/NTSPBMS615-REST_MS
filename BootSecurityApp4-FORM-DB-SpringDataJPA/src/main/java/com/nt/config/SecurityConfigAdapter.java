package com.nt.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nt.service.IUserRegistrationService;
@Configuration
@EnableWebSecurity
public class SecurityConfigAdapter extends WebSecurityConfigurerAdapter {
	@Autowired
	private IUserRegistrationService userService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//specifying Spring Data JPA related Service class as authentication Info Provider
		auth.userDetailsService(userService).passwordEncoder(encoder);
	
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//Authenticate and Authorize URLs
		
		//http.csrf().disable().authorizeRequests().antMatchers("/bank/").permitAll()
		http.authorizeRequests().antMatchers("/bank/").permitAll()
		                                                  .antMatchers("/user/register","/user/showLogin").permitAll()
														  .antMatchers("/bank/offers").authenticated()
		                                                  .antMatchers("/bank/balance").hasAnyAuthority("MANAGER","CUSTOMER")
		                                                  .antMatchers("/bank/approveLoan").hasAuthority("MANAGER")
		                                                  .anyRequest().authenticated()
		                                                  
		 //to enable BASIC Authentication(uses there browser supplied dialog box)
		 // .and().httpBasic()
		  
		 //To enable form based Authentication
		 .and().formLogin().defaultSuccessUrl("/bank/",true)
		 .loginPage("/user/showLogin")                  
		 .loginProcessingUrl("/login")
		 .failureUrl("/user/showLogin?error")
		 //enables remember Me authentication option in form based Authentication
		 .and().rememberMe()
		 
		 //enable logout
		 //.and().logout()
		 //enable logout with custom url
		 .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/bank/signout"))
		 .logoutSuccessUrl("/user/showLogin?logout")
		  //configure custom error page for 304 error page
		  .and().exceptionHandling().accessDeniedPage("/bank/denied")
		
		//Session max Concurrency control
		 .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		 
	}
}
