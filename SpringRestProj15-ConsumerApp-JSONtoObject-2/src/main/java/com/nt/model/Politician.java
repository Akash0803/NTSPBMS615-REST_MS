package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Politician {
	private Integer pid;
	private String pname;
	private String party;
	private String position;
	private Float age;
	private Float retirementAge; //Extra Property
	//HAS-A Property
	private Address addrs;
}
