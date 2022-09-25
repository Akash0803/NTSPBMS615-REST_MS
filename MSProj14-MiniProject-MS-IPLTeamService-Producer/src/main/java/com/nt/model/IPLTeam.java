package com.nt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="MS_IPLTeam")
@Data
public class IPLTeam implements Serializable{
	@Id
	@GeneratedValue
	private Integer teamId;
	@Column(length = 15)
	private String teamName;
	@Column(length = 15)
	private String owner;
	@Column(length = 15)
	private String captain;
	
	
}
