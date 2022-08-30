package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String pws1=encoder.encode("rani");
		String pws2=encoder.encode("hyd");
		String pws3=encoder.encode("begum");
		String pws4=encoder.encode("delhi");
		System.out.println(pws1);
		System.out.println(pws2);
		System.out.println(pws3);
		System.out.println(pws4);
	}
}
