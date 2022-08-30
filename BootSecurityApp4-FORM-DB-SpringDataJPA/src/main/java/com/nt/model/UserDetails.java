package com.nt.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "SECURITY_USERS")
@Data
public class UserDetails {
	@Id
	@GeneratedValue
	private Integer unid;
	@Column(length = 20, nullable = false, unique = true)
	private String uname;
	@Column(length = 100, nullable = false)
	private String pwd;
	@Column(length =20, nullable = false, unique = true)
	private String email;
	@Column(length = 1, nullable = false)
	private Boolean status=true;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "SECURITY_ROLES",joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "UNID"))
	@Column(length = 20, name = "ROLE")
	private Set<String> roles;
	
}
