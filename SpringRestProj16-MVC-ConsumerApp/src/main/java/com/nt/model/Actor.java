package com.nt.model;



import lombok.Data;
@Data
public class Actor {
	private Integer actorId;
	private String actorname;
	private String category="HERO";
	private Long mobileNo=9999999L;
}
