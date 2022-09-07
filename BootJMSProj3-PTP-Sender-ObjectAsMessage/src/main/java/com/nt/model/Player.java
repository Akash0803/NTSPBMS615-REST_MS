package com.nt.model;

import java.io.Serializable;
import java.time.LocalDateTime;
public class Player implements Serializable{

	private Integer pid;
	private String pname;
	private LocalDateTime dob;
	private String sport;
	public Player() {
		System.out.println("Player :: 0-Param Constructor");
	}
	
	
	public Player(Integer pid, String pname, LocalDateTime dob, String sport) {
		System.out.println("Player.Player() :: All Arg Constructor");
		this.pid = pid;
		this.pname = pname;
		this.dob = dob;
		this.sport = sport;
	}


	//Setters and Getters
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	//toString() alt+shift+s
	@Override
	public String toString() {
		return "Player [pid=" + pid + ", pname=" + pname + ", dob=" + dob + ", sport=" + sport + "]";
	}
	
}
