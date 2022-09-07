package com.nt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.repository.IUserDetailsRepository;
@Service("userService")
public class UserRegistrationServiceImpl implements IUserRegistrationService {
	@Autowired
	private IUserDetailsRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// use userRepo to get currently logged in user details in the form UserDetails obj
		Optional<com.nt.model.UserDetails> opt=userRepo.findByUname(username);
		if(opt.isEmpty())
			throw new IllegalArgumentException("User Not FOund");
		else {
			com.nt.model.UserDetails details=opt.get();
//			//Convert Set<String> type to Set<SGA> type Role
//			Set<GrantedAuthority> SGARoles=new HashSet<GrantedAuthority>();
//			for(String role : details.getRoles())
//			{
//				SimpleGrantedAuthority sga=new SimpleGrantedAuthority(role);
//				SGARoles.add(sga);
//				
//			}
//			//Convert Model UserDetails obj to user object
//			User user=new User(details.getUname(),details.getPwd(),SGARoles);
		
			User user=new User(details.getUname(), 
													 details.getPwd(),
													  details.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			
			return user;
		}
		
	}

	@Override
	public String registerUser(com.nt.model.UserDetails details) {
		// Encode the Password
		details.setPwd(encoder.encode(details.getPwd()));
		//Save Object
		return "User Is Registerd with "+userRepo.save(details).getUnid()+" id Value";
	}

}
