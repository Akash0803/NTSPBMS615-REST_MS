package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
@Data
public class Employee {
	private Integer empno;
	private String empname;
	private Address empaddress;
	private String[] favcolors;
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String , Long> idDetails;
}
