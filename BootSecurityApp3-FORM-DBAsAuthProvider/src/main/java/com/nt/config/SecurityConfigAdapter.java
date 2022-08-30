package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private DataSource ds;
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//using DB s/w as Authentication Info Provider through Spring JDBC
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT * FROM USERS WHERE UNAME=?")
		.authoritiesByUsernameQuery("SELECT * FROM USERS_ROLE WHERE UNAME=?");
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
